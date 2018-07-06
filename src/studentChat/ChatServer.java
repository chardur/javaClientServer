package studentChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
                ChatHandler.addChat(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in chat server");
        }
    }
}
