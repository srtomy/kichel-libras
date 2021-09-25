package io.github.srtomy.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static String getStringFromFile(String file) throws IOException {
        var arq = new FileReader(file);
        var buff = new BufferedReader(arq);

        var strFull = "";
        String linha = buff.readLine();
        while (linha != null) {
            strFull += linha;
            linha = buff.readLine(); // lê da segunda até a última linha
        }

        arq.close();
        return strFull;
    }
}
