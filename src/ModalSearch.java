import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModalSearch extends JFrame {

    public ModalSearch() {
        setBounds(300, 300, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        JButton btn = new JButton("TEST");
        add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showDialog();
            }
        });
    }

    private void showDialog() {

        JDialog dialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
        // OR, you can do the following...
        // JDialog dialog = new JDialog();
        // dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        dialog.setBounds(350, 350, 200, 200);
        dialog.setVisible(true);
    }
}