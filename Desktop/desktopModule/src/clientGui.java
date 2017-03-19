package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gwozdo on 19.03.2017.
 */
public class clientGui {
    private String messageToSend;
    private JButton connectButton;
    private JPanel pannel;
    private JTextField serverNameBox;
    private JTextField sendMessage;
    private JButton sendButton;
    private JLabel messageLabel;
    private static Client clnt;

    public static void main(String[] args) {
        JFrame clientApp = new JFrame("Client");
        clientApp.setContentPane(new clientGui().pannel);
        clientApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clientApp.pack();
        clientApp.setVisible(true);
        clnt = new Client();
        clnt.startRunning();


    }






    public clientGui() {
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageToSend = sendMessage.getText();
                clnt.sendMessage(messageToSend);

            }
        });
    }
}
