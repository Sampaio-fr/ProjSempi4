package eapli.base.app.sharedboardapp.presentation.sharedboard;

import eapli.GetSharedBoardApp;
import eapli.HttpServerBoard;
import eapli.base.app.common.console.utils.SharedBoardUtils;
import eapli.base.cell.domain.Cell;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.util.List;

public class ShowSharedBoardUI {

    private static final RcompService rcompService = new RcompService();

    @SneakyThrows
    public static void showSharedBoardUI(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_SHOW, "Show shared board"), outputStream);

        // List Shared Boards with permissions
        FormatMessage listBoards = rcompService.readData(socket, inputStream);
        String[] boards = listBoards.message().split(",");
        for (String b : boards) {
            System.out.println(b);
        }

        // Selected Shared Board to view
        System.out.println("Please insert the Shared Board name: ");
        String sharedBoard = bufferedReader.readLine();
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_SHOW, sharedBoard), outputStream);

        //Get Shared Board Cells
        FormatMessage formatMessage = rcompService.readData(socket, inputStream);
        if (formatMessage.code() == SharedBoardUtils.ACK) {
            System.out.println("Shared Board data found!");

            /* It was used ObjectInputStream because it was easier to exchange all the cells data */
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            try {

                List<Cell> cells = (List<Cell>) input.readObject();
                Desktop.getDesktop().browse(new URI("http://localhost:8081/"));

                while (true) {
                    GetSharedBoardApp viewer = new GetSharedBoardApp(sharedBoard, cells);
                    HttpServerBoard server = new HttpServerBoard("http://localhost:8081/", viewer);
                    server.start();

                    //Tempo de pausa para nao sobrecarregar a base de dados
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Incorrect Shared Board Name");
        }
    }
}
