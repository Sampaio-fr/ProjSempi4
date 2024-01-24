package eapli;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class HttpServerBoard {
    private final String ipAddress;
    static private final String BASE_FOLDER="base.app.boardviewer/src/main/java/eapli/www";
    private static GetSharedBoardApp getBoard;
    static private ServerSocket sock;
    static private Socket cliSock;
    static private String shareboard;
    static final int PORT = 8081;

    public HttpServerBoard(String ipAddress, GetSharedBoardApp viewer) {
        this.ipAddress = ipAddress;
        getBoard = viewer;
    }

    public void start() throws Exception {
        try {
            sock = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }
        while (!sock.isClosed()) {
            cliSock = sock.accept();
            HttpsBoardRequest req = new HttpsBoardRequest(cliSock, BASE_FOLDER);
            req.start();
        }
    }

    public static synchronized String getBoardTitlesHTML() {
        StringBuilder s = new StringBuilder();
        String boardName= getBoard.getSharedBoardTitle();
        s.append("<h1>"+boardName+"</h1>");
        return s.toString();
    }

    public static synchronized String boardCells() throws InterruptedException {

        List<String> rows = getBoard.getRowTitles();
        List<String> columns = getBoard.getColumnTitles();

        StringBuilder buildInHtml = new StringBuilder();
        int maxRow = rows.size() + 1;
        int maxColumn = columns.size() + 1;

        // Add table headers
        buildInHtml.append("<tr>");
        buildInHtml.append("<th></th>"); // Empty cell for the first column
        for (int j = 1; j < maxColumn; j++) {
            buildInHtml.append("<th>").append(columns.get(j - 1)).append("</th>");
        }
        buildInHtml.append("</tr>");

        // Add table rows
        for (int i = 1; i < maxRow; i++) {
            buildInHtml.append("<tr>");
            buildInHtml.append("<td>").append(rows.get(i - 1)).append("</td>"); // Row title
            for (int j = 1; j < maxColumn; j++) {
                String cellContent = getBoard.getCellContent(rows.get(i - 1),columns.get(j - 1));
                buildInHtml.append("<td>").append(cellContent).append("</td>"); // Empty cell
            }
            buildInHtml.append("</tr>");
        }
        return buildInHtml.toString();
    }


}
