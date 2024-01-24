package eapli.base.exam.application;

import eapli.framework.visitor.Visitor;

public class DefaultQuestionPrinter implements Visitor<String> {

    @Override
    public void visit(String visitee) {
        System.out.printf("%-200s", visitee);
    }
}
