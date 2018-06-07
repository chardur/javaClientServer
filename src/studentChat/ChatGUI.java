package studentChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGUI {
    public JPanel mainPanel;
    public JTextArea chatText;
    public JTextArea textArea2;
    public JButton sendButton;


        public ChatGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "You clicked the button");
            }
        });

    }
}
