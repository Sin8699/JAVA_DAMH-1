import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Slang {

    public static void TXTExport(Map<String, String> list, String pathName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(pathName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();

        for (String key : list.keySet()) {
            builder.append(key + "`" + list.get(key));
            builder.append("\n");
        }

        pw.write(builder.toString());
        pw.close();
        System.out.println("done!");
    }

    public static Map<String, String> TXTImport(String fileName) {
        Map<String, String> data = new java.util.HashMap<>();
        String line = "";
        String splitBy = "`";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] arrOfStr = line.split(splitBy);
                data.put(arrOfStr[0], arrOfStr[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
