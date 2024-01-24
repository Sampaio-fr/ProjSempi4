package eapli.base.app.sharedboardapp.presentation.sharedboard;

import eapli.base.app.common.console.utils.SharedBoardUtils;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ViewBoardHistoryUI {
    private static final RcompService rcompService = new RcompService();

    public static void viewBoardHistory(Socket socket, DataOutputStream outputStream, DataInputStream inputStream, BufferedReader bufferedReader) throws IOException {
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.VIEW_SB, "Show shared board"), outputStream);
        FormatMessage message = rcompService.readData(socket, inputStream);
        List<String> boards = List.of(message.message().split(","));

        for (String b : boards) {
            System.out.println(b);
        }
        System.out.println("Please insert the Shared Board name: ");
        String sharedBoard = bufferedReader.readLine();

        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.VIEW_SB, sharedBoard), outputStream);
        //Get Board Logs
        message = rcompService.readData(socket, inputStream);
        if (message.code() == SharedBoardUtils.ACK) {
            System.out.println(message.message());
            rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_CELLLOG,"Success to print board log"),outputStream);
        }else{
            System.out.println("Incorrect Shared Board Name");
        }
        message = rcompService.readData(socket,inputStream);
        if(message.code()==SharedBoardUtils.SB_CELLLOG){
            String cells = message.message();
            List<String> listCells = List.of(cells.split(","));

            for (int i = 0; i < listCells.size(); i++) {
                System.out.println("---CELL HISTORY---");
                System.out.println("Cell : " + listCells.get(i));
                i++;
                System.out.println("Date : " + listCells.get(i) + "\n");
            }
        }
        rcompService.sendMessage(socket,new FormatMessage(1,SharedBoardUtils.SB_POSTLOG,"Requesting Post-it history"),outputStream);
        message = rcompService.readData(socket,inputStream);
        if(message.code() == SharedBoardUtils.SB_POSTLOG){
            String postIt = message.message();
            List<String> listPostIts = List.of(postIt.split(","));
            for (int j = 0; j < listPostIts.size(); j++) {
                System.out.println("---POST-IT HISTORY---");
                System.out.println("Cell : " + listPostIts.get(j));
                j++;
                System.out.println("Post-It ID : " + listPostIts.get(j));
                j++;
                System.out.println("State : " + listPostIts.get(j));
                j++;
                System.out.println("Date : " + listPostIts.get(j) + "\n");
            }
        }
    }
}
