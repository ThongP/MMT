package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
    
    public static String getConnectRes() {
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static String getCommandRes() throws IOException {
        InputStream ips = mySocket.getInputStream();
        DataInputStream dis = new DataInputStream(ips);
        String input = dis.readUTF();
        return input;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void ShutDown() throws IOException {
        String command = "powershell.exe start-process notepad.exe";
        OutputStream ops = mySocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ops);
        dos.writeUTF(command);
        dos.flush();
    }
    
    public static void App() throws IOException {
        String command = "powershell.exe Get-Process | Where-Object { $_.MainWindowTitle } | Format-Table ID,Name";
        OutputStream ops = mySocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ops);
        dos.writeUTF(command);
        dos.flush();
    }
    
}
