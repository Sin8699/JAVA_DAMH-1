import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.util.*;

class AutoCompleteComboBox extends JComboBox {
    public int caretPos = 0;
    public JTextField tfield = null;
    public Map<String, String> dataSearch = null;
    public String typeSearch = "Slang";

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

    public void callUpdateHistory(String text) {
        this.addItem(text);
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
                        Map<String, String> result = new HashMap<String, String>();
                        if (key == '\n') {
                            callUpdateHistory(text);

                            if (typeSearch == "Slang") {
                                if (dataSearch.containsKey(text)) {
                                    result.put(text, dataSearch.get(text));
                                } else {
                                    result = Slang.getKey(dataSearch, text);
                                }
                            } else {
                                if (dataSearch.containsValue(text)) {
                                    result.put(text, dataSearch.get(text));
                                } else {
                                    result = Slang.getValue(dataSearch, text);
                                }
                            }
                            System.out.println(result);

                            new ModalSearch(text, result);

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

    public void updateTypeSearch(String typeSearchChoose) {
        typeSearch = typeSearchChoose;
    }
}