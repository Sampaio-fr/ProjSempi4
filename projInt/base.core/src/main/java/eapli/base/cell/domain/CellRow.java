package eapli.base.cell.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Cell row.
 */
@Embeddable
public class CellRow implements ValueObject {

    private String titleRow;

    private int numberRow;

    /**
     * Instantiates a new Cell row.
     *
     * @param Title  the title
     * @param number the number
     */
    public CellRow(String Title, int number) {
        this.titleRow = Title;
        this.numberRow = number;
    }

    /**
     * Instantiates a new Cell row.
     */
    protected CellRow() {}

    /**
     * Title row string.
     *
     * @return the string
     */
    public String titleRow() {
        return titleRow;
    }

    /**
     * Replace title row.
     *
     * @param titleRow the title row
     */
    public void replaceTitleRow(String titleRow) {
        this.titleRow = titleRow;
    }

    /**
     * Number row int.
     *
     * @return the int
     */
    public int numberRow() {
        return numberRow;
    }

    /**
     * Replace number row.
     *
     * @param numberRow the number row
     */
    public void replaceNumberRow(int numberRow) {
        this.numberRow = numberRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellRow cellRow = (CellRow) o;
        return numberRow == cellRow.numberRow && Objects.equals(titleRow, cellRow.titleRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleRow, numberRow);
    }

    @Override
    public String toString() {
        return  "Row: " + numberRow + "\n" +
                "Title Of Row " + titleRow + "\n" ;
    }
}
