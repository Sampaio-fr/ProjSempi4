package eapli.base.postIt.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

/**
 * The type Title.
 */
public class Title implements ValueObject {

    private String title;


    /**
     * Instantiates a new Title.
     *
     * @param title the title
     */
    public Title(String title) {
        this.title = title;
    }
    protected Title() {

    }

    /**
     * Title string.
     *
     * @return the string
     */
    public String title() {
        return title;
    }

    /**
     * Replace title.
     *
     * @param title the title
     */
    public void replaceTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return  title;
    }
}
