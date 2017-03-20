/*
 * Created by JFormDesigner on Mon Mar 20 21:49:01 CET 2017
 */

package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Kristopher Gwozdo
 */
public class clientGui extends JFrame {
    public clientGui() {
        initComponents();
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        //dropConnections();
        System.exit(0);
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        dialog1.setLocationRelativeTo(null);
        dialog1.pack();
        dialog1.setVisible(true);
    }



    private void button2ActionPerformed(ActionEvent e) {
         clientHandler.createNewClient(userNameField.getText(),serverAddressField.getText(),serverPortField.getText());
         dialog1.dispose();
    }

    private void SendButtonMouseClicked(MouseEvent e) {
        clientHandler.sendMessage(messageTextField.getText());
        System.out.println(messageTextField.getText());
    }

    private void menuFileConnectMouseClicked(MouseEvent e) {
        dialog1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dialog1.setLocationRelativeTo(null);
        dialog1.setVisible(true);
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
        topMenuBar = new JMenuBar();
        fileMenu = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem1 = new JMenuItem();
        settingsMenu = new JMenu();
        helpMenu = new JMenu();
        SendButton = new JButton();
        messageTextField = new JTextField();
        label1 = new JLabel();
        dialog1 = new JDialog();
        connectButton = new JButton();
        userNameField = new JTextField();
        serverAddressField = new JTextField();
        userNameLabel = new JLabel();
        serverAddressLabel = new JLabel();
        serverPortLabel = new JLabel();
        serverPortField = new JTextField();

        //======== this ========
        setTitle("Communicator");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== topMenuBar ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("File");

                //---- menuItem2 ----
                menuItem2.setText("Connect");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menuItem2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuFileConnectMouseClicked(e);
                    }
                });
                fileMenu.add(menuItem2);

                //---- menuItem1 ----
                menuItem1.setText("Exit");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                fileMenu.add(menuItem1);
            }
            topMenuBar.add(fileMenu);

            //======== settingsMenu ========
            {
                settingsMenu.setText("Settings");
            }
            topMenuBar.add(settingsMenu);

            //======== helpMenu ========
            {
                helpMenu.setText("Help");
            }
            topMenuBar.add(helpMenu);
        }
        setJMenuBar(topMenuBar);

        //---- SendButton ----
        SendButton.setText("Send !");
        SendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SendButtonMouseClicked(e);
            }
        });
        contentPane.add(SendButton);
        SendButton.setBounds(new Rectangle(new Point(405, 360), SendButton.getPreferredSize()));
        contentPane.add(messageTextField);
        messageTextField.setBounds(190, 360, 190, messageTextField.getPreferredSize().height);

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(125, 105, 345, label1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(720, 500));
        setSize(720, 500);
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Connect options");
            Container dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);

            //---- connectButton ----
            connectButton.setText("Connect");
            connectButton.addActionListener(e -> button2ActionPerformed(e));
            dialog1ContentPane.add(connectButton);
            connectButton.setBounds(90, 150, 115, 50);

            //---- userNameField ----
            userNameField.setText("Anonim");
            dialog1ContentPane.add(userNameField);
            userNameField.setBounds(155, 45, 105, userNameField.getPreferredSize().height);

            //---- serverAddressField ----
            serverAddressField.setText("127.0.0.1");
            dialog1ContentPane.add(serverAddressField);
            serverAddressField.setBounds(155, 75, 105, serverAddressField.getPreferredSize().height);

            //---- userNameLabel ----
            userNameLabel.setText("Define user name:");
            dialog1ContentPane.add(userNameLabel);
            userNameLabel.setBounds(new Rectangle(new Point(45, 50), userNameLabel.getPreferredSize()));

            //---- serverAddressLabel ----
            serverAddressLabel.setText("Define server address:");
            dialog1ContentPane.add(serverAddressLabel);
            serverAddressLabel.setBounds(new Rectangle(new Point(25, 80), serverAddressLabel.getPreferredSize()));

            //---- serverPortLabel ----
            serverPortLabel.setText("Define server port:");
            dialog1ContentPane.add(serverPortLabel);
            serverPortLabel.setBounds(new Rectangle(new Point(40, 110), serverPortLabel.getPreferredSize()));

            //---- serverPortField ----
            serverPortField.setText("1234");
            dialog1ContentPane.add(serverPortField);
            serverPortField.setBounds(155, 105, 105, serverPortField.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog1ContentPane.setMinimumSize(preferredSize);
                dialog1ContentPane.setPreferredSize(preferredSize);
            }
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
    private JMenuBar topMenuBar;
    private JMenu fileMenu;
    private JMenuItem menuItem2;
    private JMenuItem menuItem1;
    private JMenu settingsMenu;
    private JMenu helpMenu;
    private JButton SendButton;
    private JTextField messageTextField;
    private JLabel label1;
    private JDialog dialog1;
    private JButton connectButton;
    private JTextField userNameField;
    private JTextField serverAddressField;
    private JLabel userNameLabel;
    private JLabel serverAddressLabel;
    private JLabel serverPortLabel;
    private JTextField serverPortField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


////////////////////////////////---metody niegenerowane automatycznie-------------------//////////////////////////////////////

    // Ta metoda po uzyciu ustawia tekst na JLabelce
    public void appendMessage(String message){
        System.out.println("clientGui: message = "+ message);
        label1.setText(message);


    }


}
