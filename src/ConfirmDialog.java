import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ConfirmDialog {
    public static int UpdateSlangWord() {
        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));

        Object[] options = { "DUPLICATE", "OVERRIDE", "DISCARD" };
        int res = JOptionPane.showOptionDialog(null, "Slang word is duplicate \n Do you still want to save it?",
                "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        return res;

    }
}