package eapli.base.cell.repositories;

import eapli.base.cell.domain.Cell;
import eapli.base.cell.domain.CellColumn;
import eapli.base.cell.domain.CellRow;
import eapli.base.postIt.domain.PostIt;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface CellRepository extends DomainRepository<Long, Cell> {

    List<Cell> findBoardCells(SharedBoard board);

    PostIt findCellContent(SharedBoard board, Cell cell);

    Cell findCellByCoordinates(SharedBoard board, String titleRow, String titleColumn);

    List<Cell> findBoardEmptyCells(SharedBoard sharedBoard);

    Cell findById(long id);

    List<Cell> findOccupiedCells(SharedBoard sharedBoard);

    List<Cell> findUpdatedOccupiedCells(SharedBoard sharedBoard);
}
