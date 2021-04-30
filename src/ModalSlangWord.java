import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ModalSlangWord extends JFrame {

    private String valueSlang = "";
    private String definitionSlang = "";

    public ModalSlangWord(String dataSearch, Map<String, String> Result) {
        setBounds(300, 300, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhone = new JLabel("Phone #");
        lblPhone.setBounds(65, 68, 46, 14);
        getContentPane().add(lblPhone);

        valueSlang = new JTextField();
        valueSlang.setBounds(128, 65, 86, 20);
        getContentPane().add(valueSlang);
        valueSlang.setColumns(10);

        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(65, 115, 46, 14);
        getContentPane().add(lblEmailId);

        definitionSlang = new JTextField();
        definitionSlang.setBounds(128, 112, 247, 17);
        getContentPane().add(definitionSlang);
        definitionSlang.setColumns(10);

        JButton btnSubmit = new JButton("Add");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        getContentPane().add(btnSubmit);
    }
}