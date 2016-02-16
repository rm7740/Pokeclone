package my.project.pokeclone.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileLoader {

    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                builder.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
