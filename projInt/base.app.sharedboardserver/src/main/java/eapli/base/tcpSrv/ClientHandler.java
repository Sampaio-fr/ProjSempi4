package eapli.base.tcpSrv;


import eapli.base.CellLog.domain.CellLog;
import eapli.base.SharedBoardLog.application.ViewBoardHistoryController;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.service.ViewBoardHistoryService;
import eapli.base.app.common.console.utils.SharedBoardUtils;
import eapli.base.cell.domain.Cell;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.postIt.applications.CreatePostItController;
import eapli.base.postIt.applications.UndoPostItController;
import eapli.base.postIt.applications.UpdatePostItController;
import eapli.base.sharedBoard.application.ArchiveBoardController;
import eapli.base.sharedBoard.application.CreateSharedBoardController;
import eapli.base.sharedBoard.application.ShareBoardController;
import eapli.base.sharedBoard.application.ShowSharedBoardController;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.service.RcompService;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class ClientHandler implements Runnable {

    private final Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private static RcompService rcompService;
    private static ViewBoardHistoryService viewHistory;

    private SystemUser systemUser;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
    }

    @SneakyThrows
    public void run() {

        InetAddress clientIP = socket.getInetAddress();
        System.out.println("New client connected with IP address: " + clientIP + "\n in port: " + socket.getPort());

        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        rcompService = new RcompService();

        try {
            boolean flag = true;
            FormatMessage message;
            while (flag) {
                message = rcompService.readData(socket, dataInputStream);
                switch (message.code()) {
                    case SharedBoardUtils.COMMTEST:
                        System.out.println("Communication test requested!");
                        rcompService.sendMessage(socket, new FormatMessage(message.version(), SharedBoardUtils.ACK, "Communication is working!"), dataOutputStream);
                        break;
                    case SharedBoardUtils.DISCONN:
                        System.out.println("Disconnection request");
                        closeEverything(dataInputStream, dataOutputStream);
                        flag = false;
                        break;
                    case SharedBoardUtils.AUTH:
                        System.out.println("Authentication request");
                        sendAuthResponse(message);
                        break;
                    case SharedBoardUtils.SB_CREATE:
                        createSharedBoard(message);
                        break;
                    case SharedBoardUtils.SB_SHOW:
                        System.out.println("Show Shared Board Request");
                        showSharedBoard();
                        break;
                    case SharedBoardUtils.SB_PostIt:
                        createPostIT(message);
                        break;
                    case SharedBoardUtils.SB_UpdatePostIt:
                        updatePostIT(message);
                        break;
                    case SharedBoardUtils.SB_UndoPostIt:
                        undoPostIT(message);
                        break;
                    case SharedBoardUtils.SB_SHAREBOARD:
                        shareBoard(message);
                        break;
                    case SharedBoardUtils.VIEW_SB:
                        viewBoardHistory(message);
                        break;

                    case SharedBoardUtils.SB_ARCHIVEBOARDSTART:
                        archiveSharedBoard(message);
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("User disconnecting...");
            socket.close();
        }

    }

    public void sendAuthResponse(FormatMessage message) throws IOException {
        String[] credentials = message.message().split("\0");
        if (credentials.length == 2) {
            String email = credentials[0];
            String password = credentials[1];
            if (validateUser(email, password)) {
                rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, "SERVER: " + email + " has entered!"), dataOutputStream);
            } else {
                rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, "Authentication failed. Please check your credentials and try again."), dataOutputStream);
                //closeEverything(dataInputStream, dataOutputStream);
            }
        }
    }

    private void viewBoardHistory(FormatMessage message) throws IOException, InterruptedException {
        String sharedBoardList, cells;
        ViewBoardHistoryController viewBoardController = new ViewBoardHistoryController(systemUser);
        sharedBoardList = String.join(",", viewBoardController.findWriteAdminPermissionBoards());

        rcompService.sendMessage(socket, new FormatMessage(1, 2, sharedBoardList), dataOutputStream);
        message = rcompService.readData(socket, dataInputStream);

        String sbTitle = message.message();
        SharedBoardLog boardLog = viewBoardController.viewSharedBoardHistory(sbTitle);

        if (boardLog == null) {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, "ERROR - Check the sharedboard name"), dataOutputStream);
        } else {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, boardLog.toString()), dataOutputStream);
        }

        List<CellLog> cellLogs = viewBoardController.viewBoardCellsHistory(boardLog);
        List<String> cellLogsStr = new ArrayList<>();
        message = rcompService.readData(socket, dataInputStream);
        if (message.code() == SharedBoardUtils.SB_CELLLOG) {
            for (CellLog c : cellLogs) {
                cellLogsStr.add(String.valueOf(c.cell().identity()));
                cellLogsStr.add(String.valueOf(c.date().getTime()));

            }
            cells = String.join(",", cellLogsStr);
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CELLLOG, cells), dataOutputStream);
        }
        message = rcompService.readData(socket, dataInputStream);

        if (message.code() == SharedBoardUtils.SB_POSTLOG) {
            String postItLogsStr = viewBoardController.viewBoardPostItHistory(cellLogs);
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_POSTLOG, postItLogsStr), dataOutputStream);
        }
    }

    private void showSharedBoard() throws IOException, InterruptedException, ClassNotFoundException {
        ShowSharedBoardController controller = new ShowSharedBoardController(systemUser);
        String sharedBoardList = String.join(",", controller.findWriteAdminPermissionBoards());
        rcompService.sendMessage(socket, new FormatMessage(1, 2, sharedBoardList), dataOutputStream);
        FormatMessage ans = rcompService.readData(socket, dataInputStream);
        String sb = ans.message();

        List<Cell> sbCells = controller.sharedBoardByTitle(ans.message());

        if (sbCells.isEmpty()) {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, "ERROR - Check the sharedboard name"), dataOutputStream);
        } else {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, "Shared Board info sent!"), dataOutputStream);
            while (true) {
                List<Cell> getCells = new ArrayList<>();
                ObjectOutputStream sendcells = new ObjectOutputStream(socket.getOutputStream());
                getCells = controller.sharedBoardByTitle(sb);

                sendcells.writeObject(getCells);
                sendcells.flush();

                Thread.sleep(20000);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                input.readObject();
            }
        }
    }

    private void createSharedBoard(FormatMessage message) throws IOException {
        String[] data = message.message().split("\0");
        CreateSharedBoardController controller = new CreateSharedBoardController(systemUser);
        System.out.println(systemUser.email());

        controller.createSharedBoard(data[0], Arrays.asList(data[1].split(",")), Arrays.asList(data[2].split(",")));
        FormatMessage response = new FormatMessage(message.version(), SharedBoardUtils.ACK, "Shared board created");
        rcompService.sendMessage(socket, response, dataOutputStream);
    }

    public void createPostIT(FormatMessage message) throws IOException {
        CreatePostItController createPostItController = new CreatePostItController(systemUser);
        String sharedBoardList = "", cells = "";
        List<Cell> cellList = new ArrayList<Cell>();
        List<String> cellIDRC = new ArrayList<String>();

        sharedBoardList = String.join(",", createPostItController.findWriteAdminPermissionBoards());

        if (!sharedBoardList.isEmpty()) {

            rcompService.sendMessage(socket, new FormatMessage(1, 101, sharedBoardList), dataOutputStream);
            message = rcompService.readData(socket, dataInputStream);

            if (message.code() == 102) {
                SharedBoard sharedBoard = createPostItController.findSharedBoardString((message.message()));
                cellList = createPostItController.findEmptyCells(sharedBoard);
                for (Cell cell : cellList) {
                    cellIDRC.add(String.valueOf(cell.identity()));
                    cellIDRC.add(String.valueOf(cell.row().numberRow()));
                    cellIDRC.add(String.valueOf(cell.column().numberColumn()));
                }
                cells = String.join(",", cellIDRC);
                rcompService.sendMessage(socket, new FormatMessage(1, 103, cells), dataOutputStream);
            }
            message = rcompService.readData(socket, dataInputStream);

            if (message.code() == 104) {
                cellIDRC = List.of(message.message().split("/"));
                try {
                    createPostItController.createPostIt(createPostItController.findCell(Long.parseLong(cellIDRC.get(0))), cellIDRC.get(1), cellIDRC.get(2));
                    rcompService.sendMessage(socket, new FormatMessage(1, 2, ""), dataOutputStream);
                } catch (Exception e) {
                    rcompService.sendMessage(socket, new FormatMessage(1, 3, ""), dataOutputStream);
                }
            } else if (message.code() == SharedBoardUtils.ERR) {
                rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);
            }
        }
    }

    public void updatePostIT(FormatMessage message) throws IOException {
        UpdatePostItController updatePostItController = new UpdatePostItController(systemUser);
        String sharedBoardList = "", cells = "";
        List<Cell> cellList = new ArrayList<Cell>();
        List<String> cellIDRC = new ArrayList<String>();
        if (message.code() == 110) {
            sharedBoardList = String.join(",", updatePostItController.findWriteAdminPermissionBoards());
        }

        if (!sharedBoardList.isEmpty()) {
            rcompService.sendMessage(socket, new FormatMessage(1, 101, sharedBoardList), dataOutputStream);
            message = rcompService.readData(socket, dataInputStream);

            if (message.code() == 102) {
                cellList = updatePostItController.findOcuppiedCells(updatePostItController.findSharedBoardString((message.message())));
                for (Cell cell : cellList) {
                    cellIDRC.add(String.valueOf(cell.identity()));
                    cellIDRC.add(String.valueOf(cell.row().numberRow()));
                    cellIDRC.add(String.valueOf(cell.column().numberColumn()));
                    cellIDRC.add(String.valueOf(cell.postIt().title()));
                    cellIDRC.add(String.valueOf(cell.postIt().description()));
                }
                cells = String.join(",", cellIDRC);
                rcompService.sendMessage(socket, new FormatMessage(1, 103, cells), dataOutputStream);

                message = rcompService.readData(socket, dataInputStream);

                if (message.code() == 150) {
                    SharedBoard sharedBoard = updatePostItController.findSharedBoardString((message.message()));
                    cellList = updatePostItController.findEmptyCells(sharedBoard);
                    cellIDRC = new ArrayList<>();
                    for (Cell cell : cellList) {
                        cellIDRC.add(String.valueOf(cell.identity()));
                        cellIDRC.add(String.valueOf(cell.row().numberRow()));
                        cellIDRC.add(String.valueOf(cell.column().numberColumn()));
                    }
                    String celula = String.join("/", cellIDRC);
                    rcompService.sendMessage(socket, new FormatMessage(1, 150, celula), dataOutputStream);
                    message = rcompService.readData(socket, dataInputStream);
                    if (message.code() == 151) {
                        cellIDRC = List.of(message.message().split("/"));
                        try {
                            Cell oldCell = updatePostItController.findCell(Long.parseLong(cellIDRC.get(0)));
                            Cell newCell = updatePostItController.findCell(Long.parseLong(cellIDRC.get(0)));
                            updatePostItController.movePostit(oldCell, newCell);
                            rcompService.sendMessage(socket, new FormatMessage(1, 2, ""), dataOutputStream);
                        } catch (Exception e) {
                            rcompService.sendMessage(socket, new FormatMessage(1, 3, ""), dataOutputStream);
                        }
                    }

                } else if (message.code() == 104) {
                    cellIDRC = List.of(message.message().split("/"));
                    try {
                        updatePostItController.updatePostIt(updatePostItController.findCell(Long.parseLong(cellIDRC.get(0))), cellIDRC.get(1), cellIDRC.get(2));
                        rcompService.sendMessage(socket, new FormatMessage(1, 2, ""), dataOutputStream);
                    } catch (Exception e) {
                        rcompService.sendMessage(socket, new FormatMessage(1, 3, ""), dataOutputStream);
                    }
                }
                if (message.code() == SharedBoardUtils.ERR) {
                    rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);

                }
            }
        }
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);
    }

    public void undoPostIT(FormatMessage message) throws IOException {

        UndoPostItController undoPostItController = new UndoPostItController(systemUser);
        String sharedBoardList = "", cells = "";
        List<Cell> cellList = new ArrayList<Cell>();
        List<String> cellIDRC = new ArrayList<String>();

        sharedBoardList = String.join(",", undoPostItController.findWriteAdminPermissionBoards());

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_UndoPostIt, sharedBoardList), dataOutputStream);
        message = rcompService.readData(socket, dataInputStream);

        if (message.code() == 102) {
            cellList = undoPostItController.findUpdatedOccupiedCells(undoPostItController.findSharedBoardString((message.message())));
            for (Cell cell : cellList) {
                cellIDRC.add(String.valueOf(cell.identity()));
                cellIDRC.add(String.valueOf(cell.row().numberRow()));
                cellIDRC.add(String.valueOf(cell.column().numberColumn()));
                cellIDRC.add(String.valueOf(cell.postIt().title()));
                cellIDRC.add(String.valueOf(cell.postIt().description()));
            }
            cells = String.join(",", cellIDRC);
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_UndoPostIt, cells), dataOutputStream);
        }
        message = rcompService.readData(socket, dataInputStream);

        try {
            undoPostItController.undoPostIt(undoPostItController.findCell(Long.parseLong(message.message())));
        } catch (Exception e) {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);
        }

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, ""), dataOutputStream);

    }

    public void shareBoard(FormatMessage message) throws IOException {

        ShareBoardController sbController = new ShareBoardController(systemUser);

        String sharedBoardList = String.join(",", sbController.listOwnedBoards());

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_SHAREBOARD, sharedBoardList), dataOutputStream);
        message = rcompService.readData(socket, dataInputStream);

        String[] data = message.message().split("\0");

        String selectedBoard = data[0];
        String email = data[1];
        int option = Integer.parseInt(data[2]);
        boolean flag = false;

        if (option == 1) {
            flag = sbController.readPermission(selectedBoard, email);
        } else if (option == 2) {
            flag = sbController.writePermission(selectedBoard, email);
        }

        if (flag) {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, "SHARED"), dataOutputStream);
        } else {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, "ERROR - NOT SHARED"), dataOutputStream);
        }
    }

    public void archiveSharedBoard(FormatMessage message) throws IOException {
        ArchiveBoardController archiveBoardController = new ArchiveBoardController();

        List<String> sharedBoards = archiveBoardController.findAdminPermissionBoards();
        String sharedBoardList = String.join(",", sharedBoards);
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_SHAREDBOARDSTOARCHIVE, sharedBoardList), dataOutputStream);
        message = rcompService.readData(socket, dataInputStream);
        if (message.code() == SharedBoardUtils.SB_SHAREDBOARDSTOARCHIVE) {
            archiveBoardController.archiveSharedBoard(message.message());
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, ""), dataOutputStream);
        } else {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), dataOutputStream);
        }
    }

    public void closeEverything(DataInputStream bufferedReader, DataOutputStream bufferedWriter) throws IOException {
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ACK, "SERVER: User has left!"), dataOutputStream);
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String user, String password) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());
        AuthenticationService authenticationService = AuthzRegistry.authenticationService();
        authenticationService.authenticate(user, password, BaseRoles.nonUserValues());
        this.systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        return authenticationService.authenticate(user, password, BaseRoles.nonUserValues()).isPresent();
    }
}
