import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Menu {
    private JFrame frame = null;
    private Map<String, String> dataCurrent = new HashMap<String, String>();
    private String typeWord = "Slang";

    public void addNewWordToData(String key, String value) {
        dataCurrent.put(key, value);

    }

    // public void editNewWordToData(String key, String value) {
    // dataCurrent.put(key, value);
    // }

    public void ShowMenu(Map<String, String> data) {

        dataCurrent = data;

        List<String> slangList = new ArrayList<>(dataCurrent.keySet());
        List<String> definitionList = new ArrayList<>(dataCurrent.values());

        JPanel panel = new JPanel();

        JLabel typeWordLabel = new JLabel("Search by :", JLabel.CENTER);
        String[] choices = { "Slang", "Definition" };

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(100, 420, 100, 40);
        panel.add(cb);
        typeWordLabel.setBounds(28, 417, 70, 40);
        panel.add(typeWordLabel);
        // ItemChangeTypeSlangListener itemChangeTypeSlang = new
        // ItemChangeTypeSlangListener();

        JButton addCta = new JButton("Add +");
        addCta.setBounds(360, 20, 95, 30);
        addCta.addActionListener(e -> {
            new ModalSlangWord("Add", this);

        });
        panel.add(addCta);

        JButton editCta = new JButton("Edit");
        editCta.setBounds(470, 20, 95, 30);
        panel.add(editCta);

        JButton delCta = new JButton("Delete");
        delCta.setBounds(580, 20, 95, 30);
        panel.add(delCta);

        AutoCompleteComboBox comboBox = new AutoCompleteComboBox(typeWord, dataCurrent);
        // try {
        // var test = comboBox.tfield.getText(0, comboBox.caretPos);
        // System.out.println("text: " + test);
        // } catch (javax.swing.text.BadLocationException e) {
        // e.printStackTrace();
        // }

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

        final JList<String> slangJList = new JList(slangList.toArray());
        final JList<String> definitionJList = new JList(definitionList.toArray());

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
        panel.add(resetCta);

        var fileMenu = new JMenu("Tool");
        var playGameCta = new JMenuItem("Play Game");
        var randomCta = new JMenuItem("Random");

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

    }

}
