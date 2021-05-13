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
    static String key = "qruD/UX4Eri8rImIFnKVinNljf/DJ6mJKj5ZUXSavo4=";
    public static void main(String[] args) throws IOException {
        Socket s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"newclient:madmeg:123");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pingup:madmeg:123:"+key);
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"postglobal:madmeg:123:"+key+":hello global chat");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pinggetglobal:madmeg:123:"+key);
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"postglobal:madmeg:123:"+key+":wag1");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"pinggetglobal:madmeg:123:"+key);
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();

        s = ClientSocket.connect();
        ClientSocket.sendData(s, prefix+"shutdown:133333");
        System.out.println(ClientSocket.getData(s).readLine());
        s.close();


    }
}
