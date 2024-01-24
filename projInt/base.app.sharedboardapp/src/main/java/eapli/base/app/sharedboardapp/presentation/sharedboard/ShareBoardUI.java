package eapli.base.app.sharedboardapp.presentation.sharedboard;

import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;
import eapli.framework.io.util.Console;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ShareBoardUI {
    static final int ACK = 2;
    static final int SB_SHAREBOARD = 112;
    static final int SB_CELLSEMPTYS = 102;
    static final int SB_CREATEPOSTIT = 104;
    private static final RcompService rcompService = new RcompService();

    public static void shareBoardUI(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, BufferedReader bufferedReader) throws IOException {
        rcompService.sendMessage(socket, new FormatMessage(1, SB_SHAREBOARD, ""), outputStream);
        FormatMessage ans = rcompService.readData(socket, inputStream);

        List<String> boards = List.of(ans.message().split(","));

        if (boards.isEmpty()) System.out.println("user doesn't own any boards!");
        else {
            for (String b : boards) {
                System.out.println(b);
            }
            String selectedboard = Console.readLine("Choose a board:");

            String email = Console.readLine("Insert the email of the user you want to share this board with: ");

            int option;
            System.out.println("1.Read Permission");
            System.out.println("2.Write Permission");

            option = Console.readInteger("Choose the option correspondent to the action you desire to do (0 to exit)");

            String data = selectedboard + "\0" + email + "\0" + option;

            rcompService.sendMessage(socket, new FormatMessage(1, 404, data), outputStream);
            ans = rcompService.readData(socket, inputStream);

            if (ans.code() == ACK) {
                System.out.println("User permission granted!");
            } else {
                System.out.println(ans.message());
            }

        }

    }

}