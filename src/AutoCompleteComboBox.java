import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.util.*;

class AutoCompleteComboBox extends JComboBox {
    public int caretPos = 0;
    public JTextField tfield = null;
    public Map<String, String> dataSearch = null;

    public AutoCompleteComboBox(final Object countries[], Map<String, String> data) {
        setEditor(new BasicComboBoxEditor());
        setEditable(true);
        dataSearch = data;
    }

    public void setSelectedIndex(int index) {
        super.setSelectedIndex(index);
        tfield.setText(getItemAt(index).toString());
        tfield.setSelectionEnd(caretPos + tfield.getText().length());
        tfield.moveCaretPosition(caretPos);
    }

    public void setEditor(ComboBoxEditor editor) {
        super.setEditor(editor);
        if (editor.getEditorComponent() instanceof JTextField) {
            tfield = (JTextField) editor.getEditorComponent();
            tfield.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent event) {
                    char key = event.getKeyChar();

                    // if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key)))
                    // return;
                    caretPos = tfield.getCaretPosition();
                    String text = "";

                    try {
                        text = tfield.getText(0, caretPos);
                        if (key == '\n') {
                            new ModalSearch();
                        }
                    } catch (javax.swing.text.BadLocationException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < getItemCount(); i++) {
                        String element = (String) getItemAt(i);
                        if (element.startsWith(text)) {
                            setSelectedIndex(i);
                            return;
                        }
                    }

                }
            });
        }
    }

    public String searchData(Map<String, String> data, String typeSearch) {
        if (typeSearch == "Slang") {
            String key = "";
            try {
                key = tfield.getText(0, caretPos);
                String value = data.get(key);
                return value;
            } catch (javax.swing.text.BadLocationException e) {
                e.printStackTrace();
            }

        }

        return "";
    }
}