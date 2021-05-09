package org.madmeg.testclient;

import java.io.*;
import java.net.Socket;

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("0.0.0.0", 4200);
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println("client:newclient:madmeg:123123");
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Server said -> '" +reader.readLine()+"'");
        socket.close();


        Socket socket1 = new Socket("0.0.0.0", 4200);
        OutputStream output1 = socket1.getOutputStream();
        PrintWriter writer1 = new PrintWriter(output1, true);
        writer1.println("client:pingup:madmeg");
        InputStream input1 = socket1.getInputStream();
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(input1));
        System.out.println("Server said -> '" +reader1.readLine()+"'");
        socket1.close();

    }
}
