        /*
         * Created by JFormDesigner on Mon Mar 20 21:49:01 CET 2017
         */

        package src;

        import java.awt.*;
        import java.awt.event.*;
        import java.util.Objects;
        import javax.swing.*;
        import javax.swing.border.*;

        /**
         * @author Kristopher Gwozdo
         */
        public class clientGui extends JFrame {
            public clientGui() {
                initComponents();
            }


///////////////// TUTAJ OPISYWANE SA LISTENERY DO NASZYCH PRZYCISKOW ITP.



            private void menuItem1ActionPerformed(ActionEvent e) {
                //dropConnections();
                System.exit(0);
            }

            private void menuItem2ActionPerformed(ActionEvent e) {
                dialog1.setLocationRelativeTo(null);
                dialog1.pack();
                dialog1.setVisible(true);
            }


            // BUTTON CONNECT!
            private void button2ActionPerformed(ActionEvent e) {

                clientHandler.createNewClient(userNameField.getText(),serverAddressField.getText(),serverPortField.getText());
                listmodel.clear();
                listmodel.addElement("Connected to server");
                 dialog1.dispose();
            }

            private void SendButtonMouseClicked(MouseEvent e) {
                clientHandler.sendMessage(messageTextField.getText());
                System.out.println(messageTextField.getText());
                messageTextField.setText("");
            }

            private void menuFileConnectMouseClicked(MouseEvent e) {
                dialog1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dialog1.setLocationRelativeTo(null);
                dialog1.setVisible(true);
            }

            private void messageTextFieldKeyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==10){
                    clientHandler.sendMessage(messageTextField.getText());
                    System.out.println(messageTextField.getText());
                    messageTextField.setText("");

                }
            }

            private void createUIComponents() {
                list1 = new JList(listmodel);
            }




            private void menuFileDcActionPerformed(ActionEvent e) {
                System.out.println("DC btn clicked");
                listmodel.addElement("DISCONNECTED FROM SERVER");
                clientHandler.disconnectClient();
            }







            private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
                createUIComponents();

                topMenuBar = new JMenuBar();
                fileMenu = new JMenu();
                menuItem2 = new JMenuItem();
                menuItem3 = new JMenuItem();
                menuItem1 = new JMenuItem();
                settingsMenu = new JMenu();
                helpMenu = new JMenu();
                SendButton = new JButton();
                messageTextField = new JTextField();
                scrollPane1 = new JScrollPane();
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

                        //---- menuItem3 ----
                        menuItem3.setText("Disconnect");
                        menuItem3.addActionListener(e -> menuFileDcActionPerformed(e));
                        fileMenu.add(menuItem3);

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
                SendButton.setBounds(555, 360, 80, SendButton.getPreferredSize().height);

                //---- messageTextField ----
                messageTextField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        messageTextFieldKeyPressed(e);
                    }
                });
                contentPane.add(messageTextField);
                messageTextField.setBounds(145, 365, 405, messageTextField.getPreferredSize().height);

                //======== scrollPane1 ========
                {
                    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    scrollPane1.setAutoscrolls(true);

                    //---- list1 ----
                    list1.setBorder(LineBorder.createBlackLineBorder());
                    list1.setVisibleRowCount(999);
                    list1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    list1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    list1.setForeground(new Color(100, 187, 187));
                    scrollPane1.setViewportView(list1);
                }
                contentPane.add(scrollPane1);
                scrollPane1.setBounds(140, 10, 490, 345);

                contentPane.setPreferredSize(new Dimension(720, 500));
                setSize(720, 500);
                setLocationRelativeTo(getOwner());

                //======== dialog1 ========
                {
                    dialog1.setTitle("Connect options");
                    dialog1.setAlwaysOnTop(true);
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
                    dialog1.setSize(275, 255);
                    dialog1.setLocationRelativeTo(dialog1.getOwner());
                }
                // JFormDesigner - End of component initialization  //GEN-END:initComponents
                scrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                    public void adjustmentValueChanged(AdjustmentEvent e) {
                        e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                    }
                });
            }

            // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
            // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
            private JMenuBar topMenuBar;
            private JMenu fileMenu;
            private JMenuItem menuItem2;
            private JMenuItem menuItem3;
            private JMenuItem menuItem1;
            private JMenu settingsMenu;
            private JMenu helpMenu;
            private JButton SendButton;
            private JTextField messageTextField;
            private JScrollPane scrollPane1;
            private JList list1;
            private JDialog dialog1;
            private JButton connectButton;
            private JTextField userNameField;
            private JTextField serverAddressField;
            private JLabel userNameLabel;
            private JLabel serverAddressLabel;
            private JLabel serverPortLabel;
            private JTextField serverPortField;
            // JFormDesigner - End of variables declaration  //GEN-END:variables
            private DefaultListModel listmodel= new DefaultListModel();


            ////////////////////////////////---metody niegenerowane automatycznie-------------------//////////////////////////////////////

            // metoda odpowiedzialna za dopisywanie wiadomosci otrzymanych od serwera do listy wiadomości
            public void appendMessage(String message){
                System.out.println("clientGui: message = "+ message);
                listmodel.addElement(message);
                listmodel.getSize();

            }


        }
