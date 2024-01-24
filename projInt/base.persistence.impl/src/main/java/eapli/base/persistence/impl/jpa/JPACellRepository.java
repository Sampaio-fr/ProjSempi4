package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.cell.domain.Cell;
import eapli.base.cell.domain.CellColumn;
import eapli.base.cell.domain.CellRow;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.postIt.domain.PostIt;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JPACellRepository extends JpaAutoTxRepository<Cell, Long, Long> implements CellRepository {
    public JPACellRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    public JPACellRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }


    @Override
    public List<Cell> findBoardCells(SharedBoard boardID) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c  WHERE c.sharedBoard = :boardID",
                Cell.class);
        query.setParameter("boardID", boardID);
        return query.getResultList();
    }

    @Override
    public PostIt findCellContent(SharedBoard board, Cell cell) {
        final TypedQuery<PostIt> query = entityManager().createQuery(
                "SELECT c.postIt FROM Cell c WHERE c.sharedBoard = :board AND c = :cell",
                PostIt.class);
        query.setParameter("board", board);
        query.setParameter("cell", cell);

        List<PostIt> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public Cell findCellByCoordinates(SharedBoard board, String titleRow, String titleColumn) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c WHERE c.sharedBoard = :board AND c.row.titleRow=:titleRow AND c.column.titleColumn =:titleColumn",
                Cell.class);
        query.setParameter("board", board);
        query.setParameter("titleRow", titleRow);
        query.setParameter("titleColumn",titleColumn);

       return query.getSingleResult();
    }

    @Override
    public List<Cell> findBoardEmptyCells(SharedBoard sharedBoard) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c WHERE c.sharedBoard = :sharedBoard AND c.cellState = 'EMPTY'",
                Cell.class);
        query.setParameter("sharedBoard", sharedBoard);
        return query.getResultList();
    }

    @Override
    public Cell findById(long id) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c WHERE c.id = :id ",
                Cell.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Cell> findOccupiedCells(SharedBoard sharedBoard) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c WHERE c.sharedBoard = :sharedBoard AND c.cellState = 'OCCUPIED'",
                Cell.class);
        query.setParameter("sharedBoard", sharedBoard);
        return query.getResultList();
    }

    @Override
    public List<Cell> findUpdatedOccupiedCells(SharedBoard sharedBoard) {
        final TypedQuery<Cell> query = entityManager().createQuery(
                "SELECT c FROM Cell c WHERE c.sharedBoard = :sharedBoard AND c.cellState = 'OCCUPIED' AND c.postIt.id IN (SELECT pl.postIt.id FROM PostItLog pl WHERE pl.postItStateLog = 'Update' )",
                Cell.class);
        query.setParameter("sharedBoard", sharedBoard);
        return query.getResultList();
    }


}
