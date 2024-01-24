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

public class UndoPostItUI {
    private static final RcompService rcompService= new RcompService();

    public static void undoPostIt(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_UndoPostIt,""),outputStream);

        FormatMessage message = rcompService.readData(socket,inputStream);
        List<String> list = List.of(message.message().split(","));

        for (String boards:list) {
            System.out.println(boards);
        }
        String board = Console.readLine("Choose a board:");

        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_CELLSEMPTYS,board),outputStream);
        message =rcompService.readData(socket,inputStream);
        String cells = message.message();
        list = List.of(cells.split(","));

        for (int i = 0; i < list.size(); i++) {

            System.out.println("--------------CELL--------------");
            System.out.println("Id ->" +list.get(i));
            // ID
            i++;
            System.out.println("Row ->" +list.get(i));
            //LINHA
            i++;
            System.out.println("Column ->" + list.get(i));
            //COLUNA
            i++;
            System.out.println("--------------------------------");
            System.out.println("PostIT :");
            System.out.println("Titulo ->" +list.get(i));
            //Titulo
            i++;
            System.out.println("Descricao ->" +list.get(i));
            //Descricao
            System.out.println("--------------------------------");
        }

        int i = Console.readInteger("Choose the Id of the Cell of the PostIt you want to undo in the ShareBoard:");

        String url = String.valueOf(i);

        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_UndoPostIt,url),outputStream);
        message = rcompService.readData(socket,inputStream);

        if (message.code() == SharedBoardUtils.ACK)
        {
            System.out.println("Success");
        }else {
            System.out.println("Insucess");
        }

    }
}