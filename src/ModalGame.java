
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ModalGame extends JFrame {

    JRadioButton radioBtn1 = null;
    JRadioButton radioBtn2 = null;
    JRadioButton radioBtn3 = null;
    JRadioButton radioBtn4 = null;
    String answer = null;

    public String chooseValue() {
        if (radioBtn1.isSelected()) {
            return radioBtn1.getText();
        }
        if (radioBtn2.isSelected()) {
            return radioBtn2.getText();
        }
        if (radioBtn3.isSelected()) {
            return radioBtn3.getText();
        }
        if (radioBtn4.isSelected()) {
            return radioBtn4.getText();
        }
        return "";
    }

    public ModalGame(String typeModal, Map<String, String> data) {
        setBounds(500, 300, 500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setTitle("Play Game " + typeModal + " Word");

        Random random = new Random();

        int index = random.nextInt(data.size());

        Object keyRandom = data.keySet().toArray()[index];
        Object valueRadom = data.get(keyRandom);

        if (typeModal == "Slang") {
            answer = valueRadom.toString();

            JLabel slangLabel = new JLabel("Slang word " + keyRandom + " is mean :");
            slangLabel.setBounds(65, 30, 400, 14);
            add(slangLabel);

            List<String> definitionOpts = Slang.randomValue(data, "Definition");

            definitionOpts.add(valueRadom.toString());
            Collections.shuffle(definitionOpts);

            radioBtn1 = new JRadioButton(definitionOpts.get(0));
            radioBtn2 = new JRadioButton(definitionOpts.get(1));
            radioBtn3 = new JRadioButton(definitionOpts.get(2));
            radioBtn4 = new JRadioButton(definitionOpts.get(3));

        } else {
            answer = keyRandom.toString();

            JLabel slangLabel = new JLabel("Definition word " + valueRadom + " is  :");
            slangLabel.setBounds(65, 30, 400, 14);
            add(slangLabel);

            List<String> slangOpts = Slang.randomValue(data, "Slang");

            slangOpts.add(keyRandom.toString());
            Collections.shuffle(slangOpts);

            radioBtn1 = new JRadioButton(slangOpts.get(0));
            radioBtn2 = new JRadioButton(slangOpts.get(1));
            radioBtn3 = new JRadioButton(slangOpts.get(2));
            radioBtn4 = new JRadioButton(slangOpts.get(3));
        }
        radioBtn1.setBounds(50, 60, 450, 30);
        radioBtn2.setBounds(50, 100, 450, 30);
        radioBtn3.setBounds(50, 140, 450, 30);
        radioBtn4.setBounds(50, 180, 450, 30);

        ButtonGroup groupRadio = new ButtonGroup();
        groupRadio.add(radioBtn1);
        groupRadio.add(radioBtn2);
        groupRadio.add(radioBtn3);
        groupRadio.add(radioBtn4);

        add(radioBtn1);
        add(radioBtn2);
        add(radioBtn3);
        add(radioBtn4);

        JButton btnSubmit = new JButton("Check");

        btnSubmit.setForeground(Color.BLUE);
        btnSubmit.setBounds(200, 230, 95, 30);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueChoose = chooseValue();

                if (valueChoose.equals(answer)) {
                    JOptionPane.showMessageDialog(null, "Correct");
                } else {
                    JOptionPane.showMessageDialog(null, "InCorrect");
                }

                setVisible(false);
            }
        });

        add(btnSubmit);
    }

}