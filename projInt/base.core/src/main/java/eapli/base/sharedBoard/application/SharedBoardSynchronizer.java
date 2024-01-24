package eapli.base.sharedBoard.application;

public interface SharedBoardSynchronizer {

    Object createCellLock(Long cellId);

    Object createPostItLock(Long postItID);
}
