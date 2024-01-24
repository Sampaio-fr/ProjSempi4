package eapli.base.sharedBoard.service;

import eapli.base.sharedBoard.domain.FormatMessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * The type Rcomp service.
 */
public class RcompService {

    /**
     * Send message.
     *
     * @param socket        the socket
     * @param formatMessage the format message
     * @param outputStream  the output stream
     * @throws IOException the io exception
     */
    public void sendMessage(Socket socket, FormatMessage formatMessage, DataOutputStream outputStream) throws IOException {
        outputStream.write((byte) formatMessage.version()); // VERSION
        outputStream.write((byte) formatMessage.code()); // CODE
        outputStream.write((byte) formatMessage.data_Length_a()); // D_LENGTH_1
        outputStream.write((byte) formatMessage.data_Length_b()); // D_LENGTH_2
        outputStream.writeInt(formatMessage.message().length());
        outputStream.writeBytes(formatMessage.message()); // DATA
        outputStream.flush();
    }

    /**
     * Read data format message.
     *
     * @param sock        the sock
     * @param inputStream the input stream
     * @return the format message
     * @throws IOException the io exception
     */
    public FormatMessage readData(Socket sock, DataInputStream inputStream) throws IOException {
        int version = inputStream.read();
        int code = inputStream.read();
        int data_length_A = inputStream.read();
        int data_length_B = inputStream.read();
        int dataSize = inputStream.readInt();
        byte[] data = null;

        if (dataSize > 0) {
            data = new byte[dataSize];
            inputStream.readFully(data, 0, dataSize);
        }

        String messageData = "";
        if (data != null) {
            messageData = new String(data, StandardCharsets.UTF_8);
        }

        return new FormatMessage(version, code, messageData);
    }
}
