import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Map<String, String> values = Slang.TXTImport("src/slang.txt");

        Menu menu = new Menu();
        menu.ShowMenu(values);

    }
}
