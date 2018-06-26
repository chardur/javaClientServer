package studentChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread {


    private String userName;
    private ArrayList<ChatHandler> handlerList = new ArrayList<>();

    public ChatServer(String userName)  {
        this.userName = userName;
        }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
                ChatHandler handler = new ChatHandler(this, clientSocket, userName);
                handlerList.add(handler);
                handler.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ChatHandler> getHandlerList(){
        return handlerList;
    }
}


