package eapli;

import eapli.base.cell.domain.Cell;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.postIt.domain.PostIt;

import java.util.*;

public class GetSharedBoardApp {

    private String sharedBoard;
    private List<Cell> shbCells;
    private PostIt postIt;
    private static CellRepository cellRepo;

    private static GetSharedBoardApp instance;

    public GetSharedBoardApp(String sbTitle, List<Cell> cells) {
        this.sharedBoard = sbTitle;
        this.shbCells = cells;
    }

    public synchronized void setCells(List<Cell> cells) {
        this.shbCells = cells;
        notifyAll();
    }

    public synchronized void setTitle(String title) {
        this.sharedBoard = title;
        notifyAll();
    }

    public List<String> getRowTitles() throws InterruptedException {
        Map<String, Integer> rowMap = new HashMap<>();
        while (true) {
            synchronized (this) {
                while (shbCells.isEmpty()) {
                    wait();
                }
                for (Cell c : shbCells) {
                    String title = c.row().titleRow();
                    int number = c.row().numberRow();
                    if (!rowMap.containsKey(title) || number < rowMap.get(title)) {
                        rowMap.put(title, number);
                    }
                }

                List<String> rows = new ArrayList<>(rowMap.keySet());
                rows.sort(Comparator.comparingInt(rowMap::get));

                return rows;
            }
        }
    }

    public synchronized String getSharedBoardTitle() {
        return this.sharedBoard;
    }

    public List<String> getColumnTitles() {
        Map<String, Integer> columnMap = new HashMap<>();
        for (Cell c : this.shbCells) {
            String title = c.column().titleColumn();
            int number = c.column().numberColumn();
            if (!columnMap.containsKey(title) || number < columnMap.get(title)) {
                columnMap.put(title, number);
            }
        }
        List<String> columns = new ArrayList<>(columnMap.keySet());
        columns.sort(Comparator.comparingInt(columnMap::get));

        return columns;
    }

    public String getCellContent(String titleRow, String titleColumn) {
        for (Cell c : shbCells) {
            if (c.row().titleRow().equals(titleRow) && c.column().titleColumn().equals(titleColumn)) {
                PostIt postIt = c.postIt();
                if (postIt != null) {
                    String description = postIt.description().description();
                    if (!description.contains("http")) {
                        return ("<div class=\"sticky-note-container\"><div class=\"sticky-note-content\">" + postIt.htmlString() + "</div></div>");
                    } else {
                        //image
                        return ("<img src=\"" + description + "\" width=\"200\" height=\"200\">");
                    }
                }
            }
        }
        return "";
    }


}
