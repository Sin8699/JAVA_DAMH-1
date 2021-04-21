import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Menu {
    public static void ShowMenu(Map<String, String> data) {

        List<String> slangList = new ArrayList<>(data.keySet());
        List<String> definitionList = new ArrayList<>(data.values());

        JPanel panel = new JPanel();
        // panel.setLayout(new GridLayout(3, 4));

        String[] choices = { "Slang", "Definition" };

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(25, 420, 100, 40);
        panel.add(cb);

        JButton addCta = new JButton("Add +");
        addCta.setBounds(360, 50, 95, 30);
        panel.add(addCta);

        JButton editCta = new JButton("Edit");
        editCta.setBounds(470, 50, 95, 30);
        panel.add(editCta);

        JButton delCta = new JButton("Delete");
        delCta.setBounds(580, 50, 95, 30);
        panel.add(delCta);

        String[] countries = new String[] { "india", "australia", "newzealand", "england", "germany", "france",
                "ireland", "southafrica", "bangladesh", "holland", "america" };
        JComboBox comboBox = new AutoCompleteComboBox(countries);
        comboBox.setBounds(25, 50, 100, 40);
        panel.add(comboBox, BorderLayout.NORTH);

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

        slangScrollPane.setBounds(30, 100, 300, 300);
        definitionScrollPane.setBounds(370, 100, 300, 300);

        panel.add(slangScrollPane);
        panel.add(definitionScrollPane);

        JButton resetCta = new JButton("Reset");
        resetCta.setBounds(580, 420, 95, 30);
        panel.add(resetCta);

        var fileMenu = new JMenu("Tool");
        var playGameCta = new JMenuItem("Play Game");
        var randomCta = new JMenuItem("Random");

        fileMenu.add(playGameCta);
        fileMenu.add(randomCta);

        var menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        panel.add(menuBar);

        JFrame frame = new JFrame("SLANG WORD");

        panel.setLayout(null);
        frame.add(panel);
        frame.setJMenuBar(menuBar);

        frame.setSize(700, 530);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
