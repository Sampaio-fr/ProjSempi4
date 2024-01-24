package eapli.base.utils;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.visitor.Visitor;

import java.util.Collection;
import java.util.Iterator;

public class SelectWidgetNoExit<T> extends ListWidget<T> {
    private int option = -1;

    public SelectWidgetNoExit(final String header, final Collection<T> source) {
        super(header, source);
    }

    public SelectWidgetNoExit(final String header, final Iterable<T> source) {
        super(header, source);
    }

    public SelectWidgetNoExit(final String header, final Collection<T> source, final Visitor<T> visitor) {
        super(header, source, visitor);
    }

    public SelectWidgetNoExit(final String header, final Iterable<T> source, final Visitor<T> visitor) {
        super(header, source, visitor);
    }

    public void show() {
        super.show();
        this.option = readOptionNoExit(1, this.size());
    }

    public int selectedOption() {
        return this.option;
    }

    public T selectedElement() {
        switch (this.option) {
            case -1:
            case 0:
            default:
                return this.fromIndex();
        }
    }

    private T fromIndex() {
        int idx = 0;
        T elem = null;

        for (Iterator<T> it = this.source.iterator(); idx < this.option; ++idx) {
            elem = it.next();
        }

        return elem;
    }

    private static int readOptionNoExit(final int low, final int high) {
        int option;
        do {
            option = Console.readInteger("Select an option: ");
        } while (option < low || option > high);

        return option;
    }
}

