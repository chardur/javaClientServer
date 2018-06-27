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

    public static void main(String[] args) {
        ChatGui chat = new ChatGui();
        JFrame frame = new JFrame("ChatGui");
        frame.setContentPane(chat.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);

        String ip = JOptionPane.showInputDialog("Please enter the ip address: ");
        while (ip == null || ip.isEmpty()) {
            ip = JOptionPane.showInputDialog("Please enter the ip address: ");
        }

        String userName = JOptionPane.showInputDialog("Please enter your User name: ");
        while (userName == null || userName.isEmpty()) {
            userName = JOptionPane.showInputDialog("Please enter your User name: ");
        }

        if (!checkForServer(ip)){
            ChatServer server = new ChatServer(userName);
            server.start();
        }else{
            ChatClient client = new ChatClient(ip, 8090, userName);
            client.start();
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
    public static boolean checkForServer(String ip){

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
        return true;
    }
}
