package io.github.srtomy.gui;

import io.github.srtomy.builder.ThemeBuilder;
import io.github.srtomy.model.Keyword;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainWindow extends VBox implements KeyWordEvent {
    private List<Keyword> keywords;
    private Set<Keyword> successfulAttemptsKeyWord = new LinkedHashSet<>();
    private Set<Keyword> unsuccessfulAttemptsKeyWord = new LinkedHashSet<>();
    private GridPane grid;
    private String theme;


    public MainWindow(List<Keyword> keywords) {
        this.keywords = keywords;

        ThemeBuilder themeBuilder = new ThemeBuilder();
        theme = themeBuilder.getRandonTheme();

        initLayout();

        initActions();
    }

    private void initActions() {
        grid.setOnMouseClicked(evt->{
            var target = (Node)evt.getTarget();
            var columnIndex = GridPane.getColumnIndex(target);
        });
    }

    private void initLayout() {
        grid = new GridPane();

        int count = 0;
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                var keyWordView = new KeyWordView(keywords.get(count));
                keyWordView.setKeyWordListener(this);
                grid.add(keyWordView, coluna, linha);
                count++;
            }
        }

        this.getChildren().add(grid);

    }


    @Override
    public boolean setAssertKeyWordTheme(Keyword keyword) {
        var acert = keyword.getTheme().getName().equals(theme);
        if(acert){
            successfulAttemptsKeyWord.add(keyword);
        }else
        {
            unsuccessfulAttemptsKeyWord.add(keyword);
        }

        return  acert;
    }
}
