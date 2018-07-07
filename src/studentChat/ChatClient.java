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
        Socket clientSocket = null;
        try {
            clientSocket = new Socket(ip, 8090);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientHandler handler = new ClientHandler(clientSocket);
        handler.start();
        Main.startClient(handler);

    }
}
