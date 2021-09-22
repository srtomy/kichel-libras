package io.github.srtomy.gui;

import io.github.srtomy.builder.ThemeBuilder;
import io.github.srtomy.model.Game;
import io.github.srtomy.model.Keyword;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class MainWindow extends VBox implements KeyWordEvent {
    private final Game game;
    private final ObservableList<Keyword> successfulAttemptsKeyWord = FXCollections.observableList(new ArrayList<>());
    private final ObservableList<Keyword> unsuccessfulAttemptsKeyWord = FXCollections.observableList(new ArrayList<>());
    private GridPane grid;
    private Text txtTentativas;


    public MainWindow(List<Keyword> keywords) {
        game = new Game();
        game.setTheme(new ThemeBuilder().getRandonTheme());
        game.setKeywords(keywords);

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
        var boxHeader = new HBox();

        var lblTheme = new Label( "Tema: ");
        var txtTheme = new Text(game.getThemeCamelCase());
        var space = new Region();
        var lblTentativas = new Label("Tentativas:");
        txtTentativas = new Text(game.getActualAttempt()+"/");
        var txtTentativasMax = new Text(String.valueOf(game.getActualAttemptsMax()));

        lblTheme.setFont(Font.font(25));
        txtTheme.setFont(Font.font(null, FontWeight.BOLD, 25));
        lblTentativas.setFont(Font.font(25));
        txtTentativas.setFont(Font.font(null, FontWeight.BOLD, 25));
        txtTentativasMax.setFont(Font.font(null, FontWeight.BOLD, 25));

        boxHeader.getChildren().add(lblTheme);
        boxHeader.getChildren().add(txtTheme);


        boxHeader.getChildren().add(space);
        HBox.setHgrow(space, Priority.ALWAYS);

        boxHeader.getChildren().add(lblTentativas);
        boxHeader.getChildren().add(txtTentativas);
        boxHeader.getChildren().add(txtTentativasMax);

        this.getChildren().add(boxHeader);

        getChildren().add(new Separator(Orientation.HORIZONTAL));

        grid = new GridPane();

        int count = 0;
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                var keyWordView = new KeyWordView(game.getKeywords().get(count));
                keyWordView.setKeyWordListener(this);
                grid.add(keyWordView, coluna, linha);
                count++;
            }
        }

        VBox.setVgrow(grid, Priority.ALWAYS);

        this.getChildren().add(grid);

        var boxSucess = new VBox();
        ListView<Keyword> listViewSucess = new ListView<>();
        listViewSucess.setItems(successfulAttemptsKeyWord);
        var txtTextSuccess = new Text("Acertos");

        boxSucess.getChildren().addAll(txtTextSuccess,listViewSucess);

        var boxUnSucess = new VBox();
        ListView<Keyword> listViewUnSucess = new ListView<>();
        listViewUnSucess.setItems(unsuccessfulAttemptsKeyWord);
        var txtTextErros = new Text("Erros");

        boxUnSucess.getChildren().addAll(txtTextErros,listViewUnSucess);

        HBox hboxList = new HBox(boxSucess, boxUnSucess);
        this.getChildren().add(hboxList);
    }


    @Override
    public boolean setAssertKeyWordTheme(Keyword keyword) {
        var acert = keyword.getTheme().getName().equals(game.getTheme());
        if(acert){
            game.addHit();
            if(game.hasNewHit()){
                successfulAttemptsKeyWord.add(keyword);
            }else{
                System.exit(0);
            }
        }else
        {
            game.addAttempt();
            if(game.hasNewAttemp()){
                unsuccessfulAttemptsKeyWord.add(keyword);
                txtTentativas.setText(game.getActualAttempt()+"/");
            }else {
                System.exit(0);
            }
        }

        return  acert;
    }

}
