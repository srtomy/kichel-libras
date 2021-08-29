package io.github.srtomy.gui;

import io.github.srtomy.model.Keyword;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class KeyWordView extends StackPane {
    private Keyword keyword;
    private KeyWordEvent event;

    public KeyWordView(Keyword keyword) {
        this.keyword = keyword;
        getChildren().add(new Label(keyword.getDescription()));


        setOnMouseClicked(evt -> {
            Platform.runLater(() -> {
                if (evt.getClickCount() >= 2) {
                    if (event.setAssertKeyWordTheme(keyword)) {
                        setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY,Insets.EMPTY)));
                    } else {
                        setBackground(new Background(new BackgroundFill(Color.TOMATO,CornerRadii.EMPTY,Insets.EMPTY)));
                    }
                }
            });

        });
    }

    public void setKeyWordListener(KeyWordEvent event) {
        this.event = event;
    }


}
