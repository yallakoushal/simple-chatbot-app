import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class ChatBotGUI extends JFrame {
    JTextArea chatArea;
    JTextField userInput;

    public ChatBotGUI() {
        setTitle("Simple ChatBot");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(chatArea);
        scroll.setBounds(20, 20, 440, 250);
        add(scroll);

        userInput = new JTextField();
        userInput.setBounds(20, 290, 340, 30);
        add(userInput);

        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(380, 290, 80, 30);
        add(sendBtn);

        chatArea.append("🤖 Bot: Hello! Type something or 'bye' to exit.\n");

        sendBtn.addActionListener(e -> {
            String msg = userInput.getText().trim();
            if (msg.isEmpty()) return;
            chatArea.append("You: " + msg + "\n");
            userInput.setText("");

            String lower = msg.toLowerCase();
            String reply;

            if (lower.contains("hi") || lower.contains("hello"))
                reply = "Hi there! How can I help you?";
            else if (lower.contains("how are you"))
                reply = "I'm doing great, thanks for asking!";
            else if (lower.contains("time"))
                reply = "Current time is: " + new Date();
            else if (lower.contains("bye")) {
                reply = "Goodbye! Have a nice day!";
                chatArea.append("🤖 Bot: " + reply + "\n");
                userInput.setEnabled(false);
                sendBtn.setEnabled(false);
                return;
            } else
                reply = "Sorry, I didn’t understand that.";

            chatArea.append("🤖 Bot: " + reply + "\n");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}
