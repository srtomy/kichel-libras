package io.github.srtomy.builder;

import io.github.srtomy.model.Keyword;
import io.github.srtomy.model.Theme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KeyWordBuilder {
    public static List<Keyword> build(){
        var keywords = new ArrayList<Keyword>();

        //add animais
        var listAnimals =getListFromAnimals().stream().limit(5).collect(Collectors.toList());
        keywords.addAll(listAnimals);

        //add
        var listFoods =getListFromFood().stream().limit(5).collect(Collectors.toList());
        keywords.addAll(listFoods);

        var listColors =getListFromColors().stream().limit(5).collect(Collectors.toList());
        keywords.addAll(listColors);

        Collections.shuffle(keywords);

        return keywords;
    }

    private static List<Keyword> getListFromAnimals(){
        var keywords = new ArrayList<Keyword>();

        var theme = new Theme("campo");

        var keyword = new Keyword();
        keyword.setDescription("cavalo");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("vaca");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("ovelha");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("galinha");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("galo");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("gato");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("cachorro");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("passarinho");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("leao");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("leopardo");
        keyword.setTheme(theme);
        keywords.add(keyword);

        Collections.shuffle(keywords);

        return keywords;
    }

    private static List<Keyword> getListFromFood(){
        var keywords = new ArrayList<Keyword>();

        var theme = new Theme("alimentos");

        var keyword = new Keyword();
        keyword.setDescription("Abacaxi");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Cogumelos");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Morango");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Repolho");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Groselha");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Mamão");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Espinafre");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Lentilhas");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Feijao");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Arroz");
        keyword.setTheme(theme);
        keywords.add(keyword);

        Collections.shuffle(keywords);

        return keywords;
    }

    private static List<Keyword> getListFromColors(){











        var keywords = new ArrayList<Keyword>();

        var theme = new Theme("cores");

        var keyword = new Keyword();
        keyword.setDescription("Vermelho");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Rosa");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Amarelo");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Laranja");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Branco");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Marrom");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Preto");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Azul");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Castanho");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Verde");
        keyword.setTheme(theme);
        keywords.add(keyword);

        Collections.shuffle(keywords);

        return keywords;
    }
}
