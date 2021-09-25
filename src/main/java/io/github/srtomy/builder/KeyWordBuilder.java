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
        var listAnimals =getListFromAnimals().stream().limit(4).collect(Collectors.toList());
        keywords.addAll(listAnimals);

        //add
        var listFoods =getListFromFood().stream().limit(4).collect(Collectors.toList());
        keywords.addAll(listFoods);

        var listColors =getListFromColors().stream().limit(4).collect(Collectors.toList());
        keywords.addAll(listColors);

        Collections.shuffle(keywords);

        return keywords;
    }

    private static List<Keyword> getListFromAnimals(){
        var keywords = new ArrayList<Keyword>();

        var theme = new Theme("Animais");

        var keyword = new Keyword();
        keyword.setDescription("Cavalo");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/cavalo.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Vaca");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/vaca.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Ovelha");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/ovelha.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Galinha");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/galinha.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Galo");
        keyword.setImg(Path.of("file:img/galo.gif"));
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Gato");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/gato.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Cachorro");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/cachorro.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Passarinho");
        keyword.setImg(Path.of("file:img/passarinho.gif"));
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Leao");
        keyword.setImg(Path.of("file:img/leao.gif"));
        keyword.setTheme(theme);
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Tigre");
        keyword.setImg(Path.of("file:img/tigre.gif"));
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
        keyword.setDescription("Peixe");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/peixes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Fruta");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/frutas.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Carne");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/carnes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Ovo");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/ovos.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Vegetal");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/vegetais.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Legume");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/legumes.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Cereal");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/cereais.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Feijão");
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

        var theme = new Theme("Cores");

        var keyword = new Keyword();
        keyword.setDescription("Vermelho");
        keyword.setTheme(theme);
        keyword.setImg(Path.of("file:img/vermelho.gif"));
        keywords.add(keyword);

        keyword = new Keyword();
        keyword.setDescription("Rosa");
        keyword.setImg(Path.of("file:img/rosa.gif"));
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
        keyword.setDescription("Bege");
        keyword.setImg(Path.of("file:img/bege.gif"));
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
