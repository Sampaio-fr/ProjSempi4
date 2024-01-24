package eapli.base.app.common.console.utils;

import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;
import eapli.framework.io.util.Console;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * The type Create post it ui.
 */
public class CreatePostItUI {
    private static final RcompService rcompService= new RcompService();

    /**
     * Create post it.
     *
     * @param socket         the socket
     * @param inputStream    the input stream
     * @param outputStream   the output stream
     * @param bufferedReader the buffered reader
     * @throws IOException the io exception
     */
    public static void createPostIt(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
        rcompService.sendMessage(socket,new FormatMessage(1,100,""),outputStream);

        FormatMessage message = rcompService.readData(socket,inputStream);
        List<String> list = List.of(message.message().split(","));

        if(!list.isEmpty()) {

            for (String boards : list) {
                System.out.println(boards);
            }
            String board = Console.readLine("Choose a board:");

            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CELLSEMPTYS, board), outputStream);
            message = rcompService.readData(socket, inputStream);
            String cells = message.message();

            if (!cells.isEmpty()){
            list = List.of(cells.split(","));

            for (int i = 0; i < list.size(); i++) {
                System.out.println("--------------------------------");
                System.out.println("--------------CELL--------------");
                System.out.println("--------------------------------");
                System.out.println("Id ->" + list.get(i));
                // ID
                i++;
                System.out.println("Row ->" + list.get(i));
                //LINHA
                i++;
                System.out.println("Column ->" + list.get(i));
                //COLUNA
                System.out.println("--------------------------------");
            }
            int i = Console.readInteger("Choose the Id of the Cell where to create the ShareBoard:");
            String title = Console.readLine("Write the  title of the Post-It: ");
            String description = Console.readLine("Write the description of the Post-It: ");
            String url = i + "/" + title + "/" + description;
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CREATEPOSTIT, url), outputStream);

            message = rcompService.readData(socket, inputStream);
            }else {
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), outputStream);
            message = rcompService.readData(socket, inputStream);
            }
        }


        if (message.code() == SharedBoardUtils.ACK)
        {
            System.out.println("Success");
        }else {
            System.out.println("Insucess");
        }

}
}
