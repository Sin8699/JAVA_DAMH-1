import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ModalSearch extends JFrame {

    public ModalSearch(String dataSearch, Map<String, String> Result) {
        setBounds(300, 300, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        final JList<String> slangJList = new JList(Slang.toString(Result));
        JScrollPane slangScrollPane = new JScrollPane();
        slangScrollPane.setViewportView(slangJList);
        slangScrollPane.setLocation(0, 0);
        slangJList.setLayoutOrientation(JList.VERTICAL);

        add(slangScrollPane);

    }
}