import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, String> values = null;

        File f = new File("src/lasted-slang.txt");
        if (f.exists() && !f.isDirectory()) {
            values = Slang.TXTImport("src/lasted-slang.txt");
        } else {
            values = Slang.TXTImport("src/slang.txt");
        }

        Menu menu = new Menu();
        menu.ShowMenu(values);

    }
}
