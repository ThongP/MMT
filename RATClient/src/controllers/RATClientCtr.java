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
    private int port;
    private String host;
    private Socket mySocket;

    public RATClientCtr(String h) {
        host = h;
        port = 8888;
    }
    
    public void openSocket() {
        try {
            mySocket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getResult() {
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public void closeConn() {
        try {
            mySocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShutDown(String command) throws IOException {
        OutputStream ops = mySocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ops);
        dos.writeUTF(command);
        dos.flush();
    }
}
