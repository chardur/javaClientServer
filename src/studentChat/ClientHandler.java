package studentChat;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket s) {
        try {
            socket = s;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in client handler");
        }

    }

    public void sendUsername(String username) {
        out.println(username);
        out.flush();
    }

    public void sendChat(String chatMessage) {
        out.println(chatMessage);
        out.flush();
    }

    @Override
    public void run() {

        try {
            while (socket.isConnected() && !socket.isClosed()) {
                socket.setSoTimeout(0);
                String chatMessage = in.readLine();
                Main.getChat().addResponse(chatMessage);
                //System.out.println(chatMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
