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

    public ChatServer()  {

    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ChatHandler.addChat(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
