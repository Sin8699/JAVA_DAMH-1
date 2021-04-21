import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Menu {
    public static void ShowMenu(Map<String, String> data) {

        List<String> slangList = new ArrayList<>(data.keySet());
        List<String> definitionList = new ArrayList<>(data.values());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 4));

        String[] choices = { "Slang", "Definition" };

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(cb);

        JButton b = new JButton("Click Here");
        b.setBounds(50, 100, 95, 30);
        panel.add(b);

        String[] countries = new String[] { "india", "australia", "newzealand", "england", "germany", "france",
                "ireland", "southafrica", "bangladesh", "holland", "america" };
        JComboBox comboBox = new AutoCompleteComboBox(countries);
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

        panel.add(slangScrollPane);
        panel.add(definitionScrollPane);

        JFrame frame = new JFrame("SLANG WORD");

        frame.add(panel);

        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
