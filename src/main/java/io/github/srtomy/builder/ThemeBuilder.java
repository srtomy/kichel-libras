package io.github.srtomy.builder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class ThemeBuilder {
    private List<String> themes ;

    private void getAllThemes(){
        JSONParser parser = new JSONParser();
        themes = new ArrayList<>();
        try {
            Object obj = parser.parse(new FileReader("temas.json"));
            JSONArray jsonRoot = (JSONArray) obj;

            Iterator<String> iterator = jsonRoot.iterator();
            while (iterator.hasNext()) {
                themes.add(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String  getRandonTheme(){
        getAllThemes();

        Random random = new Random();
        var indexRandom = random.ints(0,(themes.size())).findFirst().getAsInt();
        return themes.get(indexRandom);
    }
}
