package eapli.base.app.sharedboardapp;

import eapli.GetSharedBoardApp;
import eapli.HttpServerBoard;
import eapli.base.app.common.console.utils.*;
import eapli.base.app.sharedboardapp.presentation.sharedboard.CreateSharedBoardUI;
import eapli.base.app.sharedboardapp.presentation.sharedboard.ShareBoardUI;
import eapli.base.app.sharedboardapp.presentation.sharedboard.ShowSharedBoardUI;
import eapli.base.app.sharedboardapp.presentation.sharedboard.ViewBoardHistoryUI;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    static InetAddress serverIP;
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    private static RcompService rcompService;
    final static int SERVER_PORT = 8080;

    public Client(Socket socket) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, inputStream, outputStream);
        }
    }

    private static void closeEverything(Socket socket, BufferedReader bufferedReader, DataInputStream inputStream, DataOutputStream outputStream) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static boolean authentication() throws IOException {
        FormatMessage code = rcompService.readData(socket, inputStream);
        if (code.code() == 2) {
            System.out.println("Authentication successful!");
            return true;
        } else if (code.code() == 3) {
            System.out.println("Authentication failed. Please check your credentials and try again.");
            return false;
            //closeEverything(socket, bufferedReader, inputStream,outputStream);
        }
        System.out.println("Something went wrong!");
        return false;

    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Send COMMTEST request");
        System.out.println("2. Send DISCONN request");
        System.out.println("3. Create Shared Board");
        System.out.println("4. View Shared Board");
        System.out.println("5. Create Post-It Shared-Board");
        System.out.println("6. Update Post-It Shared-Board");
        System.out.println("7. Share a Board with user");
        System.out.println("8. Undo Post-It Shared-Board");
        System.out.println("9. View Shared Board History");
        System.out.println("10. Archive Shared Board ");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) throws IOException {

        serverIP = InetAddress.getByName("vsgate-http.dei.isep.ipp.pt");
        //serverIP = InetAddress.getLocalHost();
        socket = new Socket(serverIP,11057);
        //socket = new Socket(InetAddress.getLocalHost().getHostAddress(), SERVER_PORT);
        Client client = new Client(socket);
        rcompService = new RcompService();

        boolean exit = false, auth;
        do {
            System.out.println("Email: ");
            String email = bufferedReader.readLine();

            System.out.println("Password: ");
            String password = bufferedReader.readLine();
            String data = email + "\0" + password + "\0";

            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.AUTH, data), outputStream);
            auth = authentication();

            if (auth) {
                exit = true;
            } else {
                System.out.println("Do you want to try again? (y/n)");
                if (!bufferedReader.readLine().equals("y")) {
                    exit = true;
                }
            }
        } while (!exit);

        //client.listenForMessages();

        while (auth) {
            displayMenu();

            String choice = bufferedReader.readLine();
            FormatMessage formatMessage;

            switch (choice) {
                case "1":
                    System.out.println("Testing communication");
                    rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.COMMTEST, "Teste"), outputStream);
                    formatMessage = rcompService.readData(socket, inputStream);
                    if (formatMessage.code() == SharedBoardUtils.ACK) {
                        System.out.println("Communication is established and working :) ");
                    }
                    break;
                case "2": // Disconnect
                    System.out.println("Sending DISCONN request");
                    rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.DISCONN, "Disconnect"), outputStream);
                    formatMessage = rcompService.readData(socket, inputStream);
                    if (formatMessage.code() == SharedBoardUtils.ACK) {
                        socket.close();
                        auth = false;
                        System.exit(1);
                    }
                    break;
                case "3":
                    CreateSharedBoardUI.createSharedBoard(socket, outputStream);
                    break;
                case "4":
                    ShowSharedBoardUI.showSharedBoardUI(socket, inputStream, outputStream, bufferedReader);
                    break;
                case "5":
                    CreatePostItUI.createPostIt(socket, inputStream, outputStream, bufferedReader);
                    break;
                case "6":
                    UpdatePostItUI.updatePostIt(socket, inputStream, outputStream, bufferedReader);
                    break;
                case "7":
                    ShareBoardUI.shareBoardUI(socket, inputStream, outputStream, bufferedReader);
                    break;
                case "8":
                    UndoPostItUI.undoPostIt(socket, inputStream, outputStream, bufferedReader);
                    break;
                case "9":
                  ViewBoardHistoryUI.viewBoardHistory(socket,outputStream,inputStream,bufferedReader);
                    break;
                case "10":
                    ArchiveBoardUI.archiveBoardUI(socket,outputStream,inputStream,bufferedReader);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        System.out.println("End of connection!");
        socket.close();
    }
}
