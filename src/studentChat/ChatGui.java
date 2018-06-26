package studentChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatGui {
    public JPanel mainPanel;
    public JTextArea chatText;
    public JTextArea responseText;
    public JButton sendButton;

    public ChatGui() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String response = "You: " + responseText.getText();
                responseText.setText("");
                addResponse(response);
            }
        });

        responseText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.isControlDown() || e.getKeyCode() == KeyEvent.VK_META) && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String response = "You: " + responseText.getText();
                    responseText.setText("");
                    addResponse(response);
                }
            }
        });
    }


    public void addResponse(String response) {
        chatText.setText(chatText.getText() + System.lineSeparator() + response);
    }

}
