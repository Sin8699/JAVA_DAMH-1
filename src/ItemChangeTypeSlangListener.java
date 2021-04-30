import java.awt.event.*;

public class ItemChangeTypeSlangListener implements ItemListener {
    public String value = "Slang";

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            Object item = event.getItem();
            System.out.println("item :" + item);

            value = item.toString();
        }
    }
}