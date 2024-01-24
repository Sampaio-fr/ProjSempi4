package eapli.base.question.domain;


import eapli.framework.visitor.Visitor;

public class QuestionPrinter implements Visitor<Question> {

    @Override
    public void visit(Question visitee) {
        System.out.println(visitee.identity() +"\n"+ visitee.question());
    }
}
