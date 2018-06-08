package studentChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGUI {
    public JPanel mainPanel;
    public JTextArea chatText;
    public JTextArea responseText;
    public JButton sendButton;


    public ChatGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //JOptionPane.showMessageDialog(null, "You clicked the button");
                String response = "You: " + responseText.getText();
                responseText.setText("");
                addResponse(response);
            }
        });
    }

    public void addResponse(String response) {
        chatText.setText(chatText.getText() + System.lineSeparator() + response);
    }
}
