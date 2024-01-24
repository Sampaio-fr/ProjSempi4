package eapli.base.cell.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Cell column.
 */
@Embeddable
public class CellColumn implements ValueObject {

    private String titleColumn;


    private int numberColumn;

    /**
     * Instantiates a new Cell column.
     *
     * @param title  the title
     * @param number the number
     */
    public CellColumn(String title, int number) {
        this.titleColumn = title;
        this.numberColumn = number;
    }

    /**
     * Instantiates a new Cell column.
     */
    protected CellColumn() { }


    public int numberColumn() { return numberColumn; }
    public String titleColumn(){ return titleColumn; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellColumn that = (CellColumn) o;
        return numberColumn == that.numberColumn && Objects.equals(titleColumn, that.titleColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleColumn, numberColumn);
    }

    @Override
    public String toString() {
        return  "Column: " + numberColumn + "\n" +
                "Title Of Column " + titleColumn + "\n" ;
    }

}
