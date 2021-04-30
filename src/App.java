import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        File f = new File("src/lasted-slang.txt");
        if (f.exists() && !f.isDirectory()) {
            // do something
        }

        Map<String, String> values = Slang.TXTImport("src/slang.txt");

        Menu menu = new Menu();
        menu.ShowMenu(values);

    }
}
