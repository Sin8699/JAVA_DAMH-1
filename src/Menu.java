import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    private JFrame frame = null;
    private Map<String, String> dataCurrent = new HashMap<String, String>();
    private String typeWord = "Slang";
    private JList<String> slangJList = null;
    private JList<String> definitionJList = null;

    public void addNewWordToData(String key, String value) {
        String keyUpper = key.toUpperCase();

        if (dataCurrent.containsKey(keyUpper)) {
            int res = ConfirmDialog.UpdateSlangWord();

            if (res == 0) {
                Random random = new Random();

                int number = random.nextInt(4);

                while (dataCurrent.containsKey(keyUpper + number)) {
                    number = random.nextInt(4);
                }

                JOptionPane.showMessageDialog(null, "Key saved with value : " + keyUpper + number);
                dataCurrent.put(keyUpper + number, value);

            } else if (res == 1) {// overwrite
                dataCurrent.remove(keyUpper);
                dataCurrent.put(keyUpper, value);
                JOptionPane.showMessageDialog(null, "Override slang word successfully");
            }
        } else {
            dataCurrent.put(keyUpper, value);
        }

    }

    public void editNewWordToData(String key, String value, String keyOrigin) {
        String keyUpper = key.toUpperCase();

        if (dataCurrent.containsKey(keyUpper) && !(keyOrigin.toUpperCase()).equals(keyUpper)) {
            int res = ConfirmDialog.UpdateSlangWord();

            if (res == 0) {
                Random random = new Random();

                int number = random.nextInt(4);

                while (dataCurrent.containsKey(keyUpper + number)) {
                    number = random.nextInt(4);
                }

                JOptionPane.showMessageDialog(null, "Key saved with value : " + keyUpper + number);
                dataCurrent.put(keyUpper + number, value);

            } else if (res == 1) {// overwrite
                dataCurrent.remove(keyUpper);
                dataCurrent.put(keyUpper, value);
                JOptionPane.showMessageDialog(null, "Override slang word successfully");
            }
        } else {
            dataCurrent.remove(keyUpper);
            dataCurrent.put(keyUpper, value);
        }
    }

    public void deleteWord(String key) {
        String keyUpper = key.toUpperCase();

        int opt = JOptionPane.showConfirmDialog(null, "Slang will be delete, Are you sure ?", "Warning",
                JOptionPane.OK_CANCEL_OPTION);
        System.out.println(opt);

        if (opt == 0) {
            dataCurrent.remove(keyUpper);
            JOptionPane.showMessageDialog(null, "Delete slang word successfully");
        }
    }

    public void ShowMenu(Map<String, String> data) {

        dataCurrent = data;

        List<String> slangList = new ArrayList<>(dataCurrent.keySet());
        List<String> definitionList = new ArrayList<>(dataCurrent.values());

        JPanel panel = new JPanel();

        JLabel typeWordLabel = new JLabel("Search by :", JLabel.CENTER);
        String[] choices = { "Slang", "Definition" };

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(100, 420, 200, 40);
        panel.add(cb);
        typeWordLabel.setBounds(28, 417, 70, 40);
        panel.add(typeWordLabel);
        // ItemChangeTypeSlangListener itemChangeTypeSlang = new
        // ItemChangeTypeSlangListener();

        JButton addCta = new JButton("Add +");
        addCta.setBounds(360, 20, 95, 30);
        addCta.addActionListener(e -> {
            new ModalSlangWord("Add", this, "", "");

        });
        panel.add(addCta);

        JButton editCta = new JButton("Edit");
        editCta.setBounds(470, 20, 95, 30);
        editCta.addActionListener(e -> {
            String key = null;
            String value = null;

            if (typeWord == "Slang") {
                key = slangJList.getSelectedValue();
                value = dataCurrent.get(key);

                if (key == null) {
                    JOptionPane.showMessageDialog(null, "Need select slang word to edit");
                    return;
                }
            } else {
                value = definitionJList.getSelectedValue();
                key = Slang.findValue(dataCurrent, value);

                if (value == null) {
                    JOptionPane.showMessageDialog(null, "Need select definition word to edit");
                    return;
                }
            }

            new ModalSlangWord("Edit", this, key, value);

        });
        panel.add(editCta);

        JButton delCta = new JButton("Delete");
        delCta.setBounds(580, 20, 95, 30);
        delCta.addActionListener(e -> {
            String key = null;
            String value = null;

            if (typeWord == "Slang") {
                key = slangJList.getSelectedValue();
                value = dataCurrent.get(key);

                if (key == null) {
                    JOptionPane.showMessageDialog(null, "Need select slang word to delete");
                    return;
                }
            } else {
                value = definitionJList.getSelectedValue();
                key = Slang.findValue(dataCurrent, value);

                if (value == null) {
                    JOptionPane.showMessageDialog(null, "Need select definition word to delete");
                    return;
                }
            }

            deleteWord(key);

        });
        panel.add(delCta);

        AutoCompleteComboBox comboBox = new AutoCompleteComboBox(typeWord, dataCurrent);

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object item = event.getItem();
                    typeWord = item.toString();
                    comboBox.updateTypeSearch(typeWord);
                }
            }
        });

        comboBox.setBounds(25, 20, 100, 40);
        panel.add(comboBox, BorderLayout.NORTH);

        JLabel nameSlang = new JLabel("Slang :");
        JLabel nameDefinition = new JLabel("Definition :");

        slangJList = new JList(slangList.toArray());
        definitionJList = new JList(definitionList.toArray());

        JScrollPane slangScrollPane = new JScrollPane();
        JScrollPane definitionScrollPane = new JScrollPane();

        slangScrollPane.setViewportView(slangJList);
        slangScrollPane.setLocation(0, 0);
        slangJList.setLayoutOrientation(JList.VERTICAL);

        definitionScrollPane.setViewportView(definitionJList);
        // slangPanel.setMargin(new Insets(100, 0, 0, 0));
        definitionJList.setLayoutOrientation(JList.VERTICAL);

        slangScrollPane.setBounds(27, 100, 300, 300);
        nameSlang.setBounds(27, 72, 100, 20);
        definitionScrollPane.setBounds(367, 100, 300, 300);
        nameDefinition.setBounds(367, 72, 100, 20);

        panel.add(nameSlang);
        panel.add(slangScrollPane);
        panel.add(nameDefinition);
        panel.add(definitionScrollPane);

        JButton resetCta = new JButton("Reset");
        resetCta.setBounds(580, 425, 95, 30);
        resetCta.addActionListener(e -> {
            dataCurrent = Slang.TXTImport("src/slang.txt");
            comboBox.updateData(dataCurrent);

            JOptionPane.showMessageDialog(null, "Reset successfully");
        });
        panel.add(resetCta);

        var fileMenu = new JMenu("Tool");
        var playGameCta = new JMenuItem("Play Game");
        playGameCta.addActionListener(e -> {
            new ModalGame(typeWord, dataCurrent);
        });

        var randomCta = new JMenuItem("Random");
        randomCta.addActionListener(e -> {
            Random random = new Random();

            int index = random.nextInt(dataCurrent.size());

            Object keyRandom = dataCurrent.keySet().toArray()[index];
            Object valueRadom = dataCurrent.get(keyRandom);

            JOptionPane.showMessageDialog(null, keyRandom + " - " + valueRadom);
        });

        fileMenu.add(playGameCta);
        fileMenu.add(randomCta);

        var menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        panel.add(menuBar);

        frame = new JFrame("SLANG WORD");

        panel.setLayout(null);
        frame.add(panel);
        frame.setJMenuBar(menuBar);

        frame.setSize(700, 530);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Slang.TXTExport(dataCurrent, "src/lasted-slang.txt");
                System.exit(0);
            }
        });
    }
}
