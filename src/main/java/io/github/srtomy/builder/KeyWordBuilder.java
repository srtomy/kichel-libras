package io.github.srtomy.builder;

import io.github.srtomy.model.Keyword;
import io.github.srtomy.model.Theme;

import java.nio.file.Path;
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
        keyword.setImg(Path.of("file:img/cavalo.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("vaca");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/vaca.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("ovelha");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/ovelhar.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("galinha");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/galinha.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("galo");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("gato");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/gato.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("cachorro");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/cachorro.gif"));
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
        keyword.setDescription("Leite");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/leite.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Peixes");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/peixes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Frutas");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/frutas.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Carnes");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/carnes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Ovos");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/ovos.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Vegetais");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/vegetais.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Legumes");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/legumes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Cereais");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/cereais.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Feijao");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/feijao.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Arroz");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/arroz.gif"));
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
        keyword.setImg(Path.of("file:img/vermelho.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Rosa");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Amarelo");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/amarelo.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Laranja");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/laranja.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Branco");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/branco.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Marrom");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/marrom.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Preto");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/preto.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Azul");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/azul.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Castanho");
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Verde");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/verde.gif"));
        keywords.add(keyword);

        Collections.shuffle(keywords);

        return keywords;
    }
}
