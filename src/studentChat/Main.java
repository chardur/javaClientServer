package studentChat;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Charles Durfee
 * @since CS 3230 Summer 2018
 */

public class Main {

    private static ChatGui chat;
    private static String userName;
    private static ClientHandler handler;

    public static void main(String[] args) {

        runGui();

        String ip = JOptionPane.showInputDialog("Please enter the ip address: ");
        while (ip == null || ip.isEmpty()) {
            ip = JOptionPane.showInputDialog("Please enter the ip address: ");
        }

        userName = JOptionPane.showInputDialog("Please enter your User name: ");
        while (userName == null || userName.isEmpty()) {
            userName = JOptionPane.showInputDialog("Please enter your User name: ");
        }

        try {
            if (!checkForServer(ip)){
                ChatServer server = new ChatServer();
                server.start();
                //ChatClient client = new ChatClient(ip, 8090, userName);
                //client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] firstNames =
                {"Gracie", "Charles", "Michael", "Michael", "Patrick", "Jonathan", "Clifford", "Jacob", "Margaret", "Randal", "Joshua", "Bo"};

        String[] lastNames = {"Davenport", "Durfee", "Gapas", "Gray", "Leishman", "Pedregon", "Peters", "Pitkin", "Schroeder", "Stoddard", "Wickster", "Yu"};

        TreeSet<Student> studentSet = new TreeSet<>();

        for (int i = 0; i < 12; i++) {

            studentSet.add(new Student(firstNames[i], lastNames[i], 100));
        }

        List<Student> studentList = new ArrayList<>();
        studentList.addAll(studentSet);

        TreeSet<Group> groupSet = new TreeSet<>();

        for (int i = 0; i <= 5; i++) {

            Group myGroup = new Group(studentList.get(i), studentList.get(11 - i));
            groupSet.add(myGroup);
        }

        for (Group group : groupSet) {

            for (int i = 0; i <= 4; i++) {
                chat.addResponse(group.getStudentOne().getChatMessage(i));
                chat.addResponse(group.getStudentTwo().getChatMessage(i));
            }
        }

    }

    private static void runGui() {
        chat = new ChatGui();
        JFrame frame = new JFrame("ChatGui");
        frame.setContentPane(chat.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    public static boolean checkForServer(String ip) throws IOException {

        Socket clientSocket = null;
        try {
            clientSocket = new Socket(ip, 8090);
            clientSocket.setSoTimeout(5000);
        } catch (ConnectException c) {
            System.out.println("No Server detected");
            return false;
        }catch(SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            return false;
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        ClientHandler handler = new ClientHandler(clientSocket);
        handler.start();
        Main.startClient(handler);
        return true;
    }

    public static ChatGui getChat() {
        return chat;
    }

    public static String getUserName(){
        return userName;
    }

    public static void startClient(ClientHandler h) {
        handler = h;
        h.sendUsername(userName);
    }

}