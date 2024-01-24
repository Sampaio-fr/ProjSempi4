package eapli.base.app.sharedboardapp.presentation.sharedboard;

import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.visitor.Visitor;

public class BoardsPrinter implements Visitor<SharedBoard> {

    @Override
    public void visit(SharedBoard visit) {
        System.out.printf("%-20s%-10s", visit.identity(), visit.sharedBoardTitle());
    }
}