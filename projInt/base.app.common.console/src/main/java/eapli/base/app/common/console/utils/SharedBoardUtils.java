package eapli.base.app.common.console.utils;

import com.ibm.icu.impl.Pair;
import eapli.base.postIt.applications.CreatePostItController;
import eapli.base.sharedBoard.domain.FormatMessage;
import eapli.base.sharedBoard.service.RcompService;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;

public class SharedBoardUtils {

    //================ Message_Codes ===========================
    public static final int COMMTEST = 0;
    public static final int DISCONN = 1;
    public static final int ACK = 2;
    public static final int ERR = 3;
    public static final int AUTH = 4;
    public static final int SB_CREATE = 5;
    public static final int SB_SHOW = 6;

    public static final int VIEW_SB = 9;

    public static final int SB_CELLLOG=10;

    public static final int SB_POSTLOG=11;
    public static final int SB_PostIt = 100;
    public static final int SB_SHAREDBOARDFINDER = 100;
    public static final int SB_CELLSEMPTYS = 102;
    public static final int SB_CREATEPOSTIT = 104;
    public static final int SB_UpdatePostIt = 110;
    public static final int SB_UndoPostIt = 111;
    public static final int SB_SHAREBOARD = 112;
    //======================================================
    public static final int SB_ARCHIVEBOARDSTART = 200;
    public static final int SB_SHAREDBOARDSTOARCHIVE = 201;

    //======================================================
    private static final RcompService rcompService= new RcompService();

    public static Pair<Integer, Integer> readMaxFromPropertyFile() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("base.core/src/main/resources/ecafeteria.sample.properties");
        prop.load(input);
        int maxRow = Integer.parseInt(prop.getProperty("maxRows"));
        int maxColumn = Integer.parseInt(prop.getProperty("maxColumn"));
        return Pair.of(maxRow, maxColumn);
    }
}
