import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.util.*;

class AutoCompleteComboBox extends JComboBox {
    public int caretPos = 0;
    public JTextField tfield = null;
    public Map<String, String> dataSearch = null;
    public String typeSearch = "Slang";

    public AutoCompleteComboBox(String typeSearchInput, Map<String, String> data) {
        System.out.println("type comboBox: " + typeSearchInput);
        setEditor(new BasicComboBoxEditor());
        setEditable(true);
        dataSearch = data;
        typeSearch = typeSearchInput;
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

                            System.out.println(typeSearch + " - " + text + ": " + dataSearch.containsValue(text));

                            if (typeSearch == "Slang") {
                                if (dataSearch.containsKey(text)) {
                                    result.put(text, dataSearch.get(text));
                                } else {

                                    try {
                                        result = Slang.getKey(dataSearch, text);
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                            } else {
                                try {
                                    result = Slang.getValue(dataSearch, text);
                                } catch (Exception e) {
                                    System.out.println(e);
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