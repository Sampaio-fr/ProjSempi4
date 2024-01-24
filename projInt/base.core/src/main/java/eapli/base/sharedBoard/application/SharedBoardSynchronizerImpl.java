package eapli.base.sharedBoard.application;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBoardSynchronizerImpl implements SharedBoardSynchronizer {

    private static SharedBoardSynchronizerImpl instance;

    private final ReentrantLock lock = new ReentrantLock(true);

    private final ConcurrentHashMap<Long, Object> cellLockMap = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Long, Object> postItLockMap = new ConcurrentHashMap<>();

    public static SharedBoardSynchronizerImpl getInstance() {
        if (instance == null) {
            instance = new SharedBoardSynchronizerImpl();
        }
        return instance;
    }

    private SharedBoardSynchronizerImpl() {
    }

    public ReentrantLock getLock(){
        return lock;
    }

    @Override
    public Object createCellLock(Long cellId) {
        return cellLockMap.computeIfAbsent(cellId, object -> new Object());
    }

    @Override
    public Object createPostItLock(Long postItID) {
        return postItLockMap.computeIfAbsent(postItID, object -> new Object());
    }
}
