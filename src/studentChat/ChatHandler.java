package studentChat;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ChatHandler extends Thread {

    private ChatServer chatServer;
    private String userName;
    private Socket clientSocket;
    private OutputStream out;

    public ChatHandler(ChatServer chatServer, Socket clientSocket, String userName){

        this.clientSocket = clientSocket;
        this.userName = userName;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try {
            chatHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chatHandler() throws IOException {
        //DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        //System.out.println(in.readUTF());
        InputStream in = clientSocket.getInputStream();

        //DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        //out.writeUTF("Thank you for connecting to " + clientSocket.getLocalSocketAddress());
        this.out = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String inputLine;

        List<ChatHandler> handlerList = chatServer.getHandlerList();

        while ((inputLine = reader.readLine()) != null){
            String message = userName + ": " + inputLine +"\n";
            for(ChatHandler handler : handlerList){
                handler.send(message);
            }
        }

        //out.write(("Thank you for connecting to " + clientSocket.getLocalSocketAddress()).getBytes());
    }

    private void send(String message) throws IOException {
        out.write(message.getBytes());
    }
}
