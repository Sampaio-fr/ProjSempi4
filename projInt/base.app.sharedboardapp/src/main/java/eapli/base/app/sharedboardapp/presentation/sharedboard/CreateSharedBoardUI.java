package eapli.base.app.sharedboardapp.presentation.sharedboard;

import com.ibm.icu.impl.Pair;
import eapli.base.app.common.console.utils.SharedBoardUtils;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;
import eapli.framework.io.util.Console;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static eapli.base.app.common.console.utils.SharedBoardUtils.readMaxFromPropertyFile;

public class CreateSharedBoardUI {
    private static final RcompService rcompService = new RcompService();

    public static void createSharedBoard(Socket socket, DataOutputStream dataOutputStream) throws IOException {
        List<String> rowsTitles = new ArrayList<>();
        List<String> columnsTitles = new ArrayList<>();
        String title = Console.readLine("Enter shared board title:");

        Pair<Integer, Integer> maxValues = readMaxFromPropertyFile();
        int maxRows = maxValues.first;
        int maxColumns = maxValues.second;

        int numRows = getValidNumberOfRows(maxRows);
        int numColumns = getValidNumberOfColumns(maxColumns);

        getRowTitles(rowsTitles, numRows);
        getColumnTitles(columnsTitles, numColumns);

        String rowData = String.join(",", rowsTitles);
        String columnData = String.join(",", columnsTitles);
        String data = title + '\0' + rowData + '\0' + columnData;

        // Send create board request
        rcompService.sendMessage(socket, new FormatMessage(1, SharedBoardUtils.SB_CREATE, data), dataOutputStream);
        FormatMessage response = rcompService.readData(socket, new DataInputStream(socket.getInputStream()));

        // Check if board creation was successful
        if (response.code() == SharedBoardUtils.ACK) {
            System.out.println("Shared board created successfully.");
        } else {
            System.out.println("Failed to create shared board.");
        }
    }

    private static int getValidNumberOfRows(int maxRows) {
        int numRows;
        do {
            numRows = Console.readInteger("Enter number of rows (up to " + maxRows + "): ");
            if (numRows > maxRows) {
                System.out.println("Invalid input. Number of rows cannot exceed " + maxRows + ".");
            }
        } while (numRows > maxRows);
        return numRows;
    }

    private static int getValidNumberOfColumns(int maxColumns) {
        int numColumns;
        do {
            numColumns = Console.readInteger("Enter number of columns (up to " + maxColumns + "): ");
            if (numColumns > maxColumns) {
                System.out.println("Invalid input. Number of columns cannot exceed " + maxColumns + ".");
            }
        } while (numColumns > maxColumns);
        return numColumns;
    }

    private static void getRowTitles(List<String> rowsTitles, int numRows) {
        for (int i = 0; i < numRows; i++) {
            rowsTitles.add(Console.readLine("Enter title for row " + (i + 1) + ": "));
        }
    }

    private static void getColumnTitles(List<String> columnsTitles, int numColumns) {
        for (int j = 0; j < numColumns; j++) {
            columnsTitles.add(Console.readLine("Enter title for column " + (j + 1) + ": "));
        }
    }

}
