package studentChat;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChatHandler extends Thread {

    private String userName;
    private Socket clientSocket;
    private static ConcurrentMap<String, ChatHandler> clientsList = new ConcurrentHashMap<>();
    private BufferedReader in;
    private PrintWriter out;

    private ChatHandler(Socket clientSocket){

        this.clientSocket = clientSocket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            clientSocket.setSoTimeout(8000);
            userName = in.readLine();
            clientSocket.setSoTimeout(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in ChatHandler");
        }
    }

    @Override
    public void run() {
        try {
            while (clientSocket.isConnected() && !clientSocket.isClosed()) {
                String message = in.readLine();
                out.println("You said: " + message);
                out.flush();

                for (String username: clientsList.keySet()) {
                    if (username.equals(this.userName)) {
                        continue;
                    }

                    clientsList.get(username).send(this.userName, message);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Client disconnected");
        }
    }

    public static void addChat(Socket socket) {
        ChatHandler handler = null;
        try {
            handler = new ChatHandler(socket);
            handler.start();
            System.out.println("username " + handler.getUserName() + socket.toString());

            if (!clientsList.containsKey(handler.getUserName())) {
                handler.sendAck();
            }
            else {
                socket.close();
                return;
            }
            clientsList.putIfAbsent(handler.getUserName(), handler);
            new Thread(handler).start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in addChat");
        }
    }

    private void send(String sendingUsername, String message) {
        if (out != null && sendingUsername != null && message != null) {
            out.println(sendingUsername + " says: " + message);
            out.flush();
            Main.getChat().addResponse(sendingUsername + ": " + message);
        }
     }

    public String getUserName() {
        return userName;
    }

    private void sendAck() {
        out.println("ACK\n");
        out.flush();
    }
}