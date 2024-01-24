package eapli.base.sharedBoard.domain;

/**
 * The type Format message.
 */
public class FormatMessage {

    private int version;
    private int code;
    private int data_Length_a;
    private int data_Length_b;
    private String message;

    /**
     * Instantiates a new Format message.
     *
     * @param version       the version
     * @param code          the code
     * @param message       the message
     */
    public FormatMessage(int version, int code,String message) {
        int datalenghtA = message.length();
        int datalenghtB = 0;
        if (datalenghtA > 255) {
            datalenghtB = datalenghtA - 255;
            datalenghtA = 255;
        }

        checkSize(version, datalenghtA, datalenghtB,message);
        this.version = version;
        this.code = code;
        this.data_Length_a = datalenghtA;
        this.data_Length_b = datalenghtB;
        this.message = message;

    }

    private void checkSize(int version, int dataLengthA, int dataLengthB,String message) {
        if (version < 0 || version > 255 || dataLengthA < 0 || dataLengthB < 0 || dataLengthA >255 || dataLengthB > 255){
            System.out.println(dataLengthB);
            throw new IllegalArgumentException("Version OR dataLengthA OR dataLengthB must be between 0 and 255");
        }
        if (message.length() > dataLengthA+256 * dataLengthB){
            throw new IllegalArgumentException("Error: Message");
        }
    }

    /**
     * Version int.
     *
     * @return the int
     */
    public int version() {
        return version;
    }

    /**
     * Replace version.
     *
     * @param version the version
     */
    public void replaceVersion(int version) {
        this.version = version;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    /**
     * Replace code.
     *
     * @param code the code
     */
    public void replaceCode(int code) {
        this.code = code;
    }

    /**
     * Data length a int.
     *
     * @return the int
     */
    public int data_Length_a() {
        return data_Length_a;
    }

    /**
     * Replace data length a.
     *
     * @param data_Length_a the data length a
     */
    public void replaceData_Length_a(int data_Length_a) {
        this.data_Length_a = data_Length_a;
    }

    /**
     * Data length b int.
     *
     * @return the int
     */
    public int data_Length_b() {
        return data_Length_b;
    }

    /**
     * Replace data length b.
     *
     * @param data_Length_b the data length b
     */
    public void replaceData_Length_b(int data_Length_b) {
        this.data_Length_b = data_Length_b;
    }

    /**
     * Message string.
     *
     * @return the string
     */
    public String message() {
        return message;
    }

    /**
     * Replace message.
     *
     * @param message the message
     */
    public void replaceMessage(String message) {
        this.message = message;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
