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

    }

    private void button1ActionPerformed(ActionEvent e) {
        clientHandler.sendMessage(textField1.getText());
    }

    private void button2ActionPerformed(ActionEvent e) {
         clientHandler.createNewClient();
         button2.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menu3 = new JMenu();
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem2 ----
                menuItem2.setText("Connect");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);

                //---- menuItem1 ----
                menuItem1.setText("Exit");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Settings");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Help");
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(290, 110), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(85, 115, 190, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(80, 180, 345, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Connect");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(85, 30), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(720, 500));
        setSize(720, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kristopher Gwozdo
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenu menu3;
    private JButton button1;
    private JTextField textField1;
    private  JLabel label1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


////////////////////////////////----------------------------------------------------------------//////////////////////////////////////

    public void appendMessage(String message){
        System.out.println("clientGui: message = "+ message);
        label1.setText(message);


    }


}
