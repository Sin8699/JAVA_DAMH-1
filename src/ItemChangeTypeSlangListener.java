import java.awt.event.*;

public class ItemChangeTypeSlangListener implements ItemListener {
    public String value = "";

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            Object item = event.getItem();
            value = item.toString();
        }
    }
}
