package eapli.base.app.common.console.utils;

import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;
import eapli.framework.io.util.Console;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Update post it ui.
 */
public class UpdatePostItUI {
    private static final RcompService rcompService= new RcompService();

    /**
     * Update post it.
     *
     * @param socket         the socket
     * @param inputStream    the input stream
     * @param outputStream   the output stream
     * @param bufferedReader the buffered reader
     * @throws IOException the io exception
     */
    public static void updatePostIt(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
        boolean flag;
        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_UpdatePostIt,""),outputStream);

        FormatMessage message = rcompService.readData(socket,inputStream);
        if (message.code() != SharedBoardUtils.ERR ){
        List<String> list = List.of(message.message().split(","));
        if(!list.isEmpty()) {
            for (String boards : list) {
                System.out.println(boards);
            }
            String board = Console.readLine("Choose a board:");

            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CELLSEMPTYS, board), outputStream);
            message = rcompService.readData(socket, inputStream);
            String cells = message.message();
            list = List.of(cells.split(","));
            if (!cells.isEmpty()){
            for (int i = 0; i < list.size(); i++) {

                System.out.println("--------------CELL--------------");
                System.out.println("Id ->" + list.get(i));
                // ID
                i++;
                System.out.println("Row ->" + list.get(i));
                //LINHA
                i++;
                System.out.println("Column ->" + list.get(i));
                //COLUNA
                i++;
                System.out.println("--------------------------------");
                System.out.println("PostIT :");
                System.out.println("Titulo ->" + list.get(i));
                //Titulo
                i++;
                System.out.println("Descricao ->" + list.get(i));
                //Descricao
                System.out.println("--------------------------------");
            }
            int oldCell = Console.readInteger("Choose the Id of the Cell where to update the ShareBoard:");
            flag = Console.readBoolean("You want to move the cell y or n");
            if (flag){
                rcompService.sendMessage(socket, new FormatMessage(1,150, board), outputStream);
                message = rcompService.readData(socket, inputStream);
                String celula = message.message();
                List<String>lista = new ArrayList<>();
                lista = List.of(celula.split("/"));
                if (!lista.isEmpty()){
                    for (int x = 0; x < lista.size(); x++) {

                        System.out.println("--------------Where To Move--------------");
                        System.out.println("-------------------CELL------------------");
                        System.out.println("Id ->" + lista.get(x));
                        // ID
                        System.out.println();
                        x++;
                        System.out.println("Row ->" + lista.get(x));
                        System.out.println();
                        //LINHA
                        x++;
                        System.out.println("Column ->" + lista.get(x));
                        //COLUNA
                        System.out.println();
                    }
                int newCell = Console.readInteger("Choose the Id of the Cell where to update the ShareBoard:");
                String url = oldCell + "/" + newCell;
                rcompService.sendMessage(socket, new FormatMessage(1, 151, url), outputStream);
                message = rcompService.readData(socket, inputStream); }
            } else {
            String title = Console.readLine("Write the title of the Post-It to update: ");
            String description = Console.readLine("Write the description of the Post-It to update: ");
            String url = oldCell + "/" + title + "/" + description;
            rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CREATEPOSTIT, url), outputStream);
            message = rcompService.readData(socket, inputStream);
            }
        }
            else {
                rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR,""), outputStream);
                message = rcompService.readData(socket, inputStream);
        }

        if (message.code() == SharedBoardUtils.ACK)
        {
            System.out.println("Success");
        }else {
            System.out.println("Insucess");
        }
        }

}
}
}