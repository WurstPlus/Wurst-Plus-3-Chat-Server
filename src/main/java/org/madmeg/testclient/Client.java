package org.madmeg.testclient;

import org.madmeg.testclient.networkingClient.ClientSocket;

import java.io.*;
import java.net.Socket;

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

public class Client {
    static String prefix = "client:";
    public static void main(String[] args) throws IOException {
        Socket s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"newclient:madmeg:123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pingup:madmeg:123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pinggetdm:madmeg:123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"newclient:madmeg3:126");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pingup:madmeg3:126");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"dmuser:madmeg3:126:123:hello Madmeg");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"dmuser:madmeg3:126:123:hello madmeg1213123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pinggetdm:madmeg:123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"shutdown:133333");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

    }
}
