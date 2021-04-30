import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

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
                try {
                    data.put(arrOfStr[0], arrOfStr[1]);

                } catch (Exception e) {
                    data.put(arrOfStr[0], arrOfStr[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static Map<String, String> getKey(Map<String, String> map, String value) {
        Map<String, String> Result = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ((entry.getKey().toUpperCase()).contains(value.toUpperCase())) {
                Result.put(entry.getKey(), entry.getValue());
            }
        }
        return Result;
    }

    public static Map<String, String> getValue(Map<String, String> map, String value) {
        Map<String, String> Result = new HashMap<String, String>();
        for (Entry<String, String> entry : map.entrySet()) {
            if ((entry.getValue().toUpperCase()).contains(value.toUpperCase())) {
                Result.put(entry.getKey(), entry.getValue());
            }
        }
        return Result;
    }

    public static Object[] toString(Map<String, String> map) {
        List<String> textList = new ArrayList<String>();

        for (Entry<String, String> entry : map.entrySet()) {
            textList.add(entry.getKey().toString() + " - " + entry.getValue().toString());
        }

        return textList.toArray();
    }
}
