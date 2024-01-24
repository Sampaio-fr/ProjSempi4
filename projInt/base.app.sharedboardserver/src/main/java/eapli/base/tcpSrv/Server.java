package eapli.base.tcpSrv;


import eapli.base.sharedBoard.service.RcompService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    private static RcompService rcompService;
    final static int SERVER_PORT = 8080;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            rcompService = new RcompService();
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        //ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        ServerSocket serverSocket = new ServerSocket(2224);

        Server server = new Server(serverSocket);
        server.startServer();
    }

}
