package studentChat;

import java.io.*;
import java.net.Socket;

public class ChatClient extends Thread{

    private String ip;
    private int port;
    private String userName;

    public ChatClient(String ip, int port, String userName) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket(ip, 8090);
            ClientHandler handler = new ClientHandler(clientSocket);
            handler.start();
            handler.sendUsername(userName);
            handler.sendUsername(userName);
            Main.startClient(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
