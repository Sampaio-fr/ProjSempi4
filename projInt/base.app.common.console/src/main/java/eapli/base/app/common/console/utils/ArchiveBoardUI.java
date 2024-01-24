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

public class ArchiveBoardUI {

    private static final RcompService rcompService= new RcompService();


    public static void archiveBoardUI(Socket socket, DataOutputStream outputStream, DataInputStream inputStream, BufferedReader bufferedReader) throws IOException {
      rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_ARCHIVEBOARDSTART, ""), outputStream);
      FormatMessage message = rcompService.readData(socket, inputStream);

      if (message.code() ==SharedBoardUtils.SB_SHAREDBOARDSTOARCHIVE){
          List<String> list = List.of(message.message().split(","));
          if(!list.isEmpty()) {
              for (String boards : list) {
                  System.out.println(boards);
              }
              String board = Console.readLine("Choose a board:");
              rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_SHAREDBOARDSTOARCHIVE, board), outputStream);
          }else{
              rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.ERR, ""), outputStream);
          }
      }

        message = rcompService.readData(socket, inputStream);
      if (message.code() == SharedBoardUtils.ACK){
          System.out.println("Sucess");
      }else {
          System.out.println("Insucess");
      }



    }
}
