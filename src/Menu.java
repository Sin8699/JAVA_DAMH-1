import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Menu {
    public static void ShowMenu(Map<String, String> data) {

        List<String> slangList = new ArrayList<>(data.keySet());
        List<String> definitionList = new ArrayList<>(data.values());

        JPanel slangPanel = new JPanel();
        JPanel definitionPanel = new JPanel();

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

        slangPanel.add(slangScrollPane);
        definitionPanel.add(definitionScrollPane);

        JFrame frame = new JFrame("SLANG WORD");
        frame.add(slangPanel);
        frame.add(definitionPanel);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
