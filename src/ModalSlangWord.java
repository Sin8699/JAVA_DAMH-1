import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class ModalSlangWord extends JFrame {

    private JTextField slangJText = null;
    private JTextField definitionJText = null;

    public ModalSlangWord(String typeModal, Menu menu, String key, String value) {
        setBounds(500, 300, 500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setTitle(typeModal + " Word");

        JLabel slangLabel = new JLabel("Slang :");
        slangLabel.setBounds(65, 68, 200, 14);
        add(slangLabel);

        slangJText = new JTextField(100);
        slangJText.setBounds(160, 65, 247, 20);
        add(slangJText);

        JLabel definitionLabel = new JLabel("Definition :");
        definitionLabel.setBounds(65, 115, 200, 14);
        add(definitionLabel);

        definitionJText = new JTextField(100);
        definitionJText.setBounds(160, 112, 247, 17);

        if (typeModal == "Edit") {
            slangJText.setText(key);
            definitionJText.setText(value);
        }
        add(definitionJText);

        JButton btnSubmit = new JButton(typeModal);

        btnSubmit.setForeground(Color.BLUE);
        btnSubmit.setBounds(200, 230, 95, 30);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (typeModal == "Edit") {
                    menu.editNewWordToData(slangJText.getText(), definitionJText.getText(), key);
                } else {
                    menu.addNewWordToData(slangJText.getText(), definitionJText.getText());
                }
                setVisible(false);
            }
        });

        add(btnSubmit);
    }

}