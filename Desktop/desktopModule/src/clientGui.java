import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gwozdo on 18.03.2017.
 */
public class clientGui {
    private JButton connectBtn;

    public clientGui() {
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectionClass.connect();
            }
        });
    }
}
