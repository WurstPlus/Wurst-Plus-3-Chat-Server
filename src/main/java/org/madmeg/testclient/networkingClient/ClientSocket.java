package org.madmeg.testclient.networkingClient;

import java.io.*;
import java.net.Socket;

/**
 * @author Madmegsox1
 * @since 10/05/2021
 */

public class ClientSocket {
    public static Socket connect() throws IOException {
        return new Socket("0.0.0.0", 4200);
    }

    public static BufferedReader getData(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(stream));
    }

    public static void sendData(Socket socket, String data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(stream, true);
        writer.println(data);
    }
}
