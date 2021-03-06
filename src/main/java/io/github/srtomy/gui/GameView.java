package io.github.srtomy.gui;

import io.github.srtomy.builder.ThemeBuilder;
import io.github.srtomy.model.Game;
import io.github.srtomy.model.Keyword;
import io.github.srtomy.model.Record;
import io.github.srtomy.repository.RecordRepository;
import io.github.srtomy.service.RecordService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
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
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class GameView extends VBox implements KeyWordEvent {
    private Stage mainWindows;
    private final Game game;
    private final RecordRepository repository = new RecordService();
    private final ObservableList<Keyword> successfulAttemptsKeyWord = FXCollections.observableList(new ArrayList<>());
    private final ObservableList<Keyword> unsuccessfulAttemptsKeyWord = FXCollections.observableList(new ArrayList<>());
    private GridPane grid;
    private Text txtTentativas;
    private int timeDuration;


    public GameView(List<Keyword> keywords, String playerName, Stage mainWindows) {
        game = new Game();
        game.setTheme(new ThemeBuilder().getRandonTheme());
        game.setKeywords(keywords);
        game.setPlayer(playerName);

        this.mainWindows = mainWindows;

        initLayout();

        initActions();
    }

    private void initActions() {
        grid.setOnMouseClicked(evt -> {
            var target = (Node) evt.getTarget();
            var columnIndex = GridPane.getColumnIndex(target);
        });
    }

    private void initLayout() {
        this.setAlignment(Pos.CENTER);

        var boxHeader = new HBox();
        boxHeader.setAlignment(Pos.CENTER);

        var lblTheme = new Label("Tema: ");
        var txtTheme = new Text(game.getThemeCamelCase());
        var space1 = new Region();
        var space2 = new Region();
        var lblTentativas = new Label("Tentativas:");
        txtTentativas = new Text(game.getActualAttempt() + "/");
        var txtTentativasMax = new Text(String.valueOf(game.getActualAttemptsMax()));

        lblTheme.setFont(Font.font(25));
        txtTheme.setFont(Font.font(null, FontWeight.BOLD, 25));
        lblTentativas.setFont(Font.font(25));
        txtTentativas.setFont(Font.font(null, FontWeight.BOLD, 25));
        txtTentativasMax.setFont(Font.font(null, FontWeight.BOLD, 25));

        boxHeader.getChildren().add(lblTheme);
        boxHeader.getChildren().add(txtTheme);

        boxHeader.getChildren().add(space1);
        HBox.setHgrow(space1, Priority.ALWAYS);

        //time
        var clock = new Label();
        var timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            timeDuration++;

            final String FORMAT = "%02d:%02d";
            var strTime = String.format(FORMAT,
                    TimeUnit.MILLISECONDS.toMinutes(timeDuration) - TimeUnit.HOURS.toMinutes(
                            TimeUnit.MILLISECONDS.toHours(timeDuration)),
                    TimeUnit.MILLISECONDS.toSeconds(timeDuration) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(timeDuration)));
            clock.setText(strTime);

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        boxHeader.getChildren().add(clock);

        boxHeader.getChildren().add(space2);
        HBox.setHgrow(space2, Priority.ALWAYS);

        boxHeader.getChildren().add(lblTentativas);
        boxHeader.getChildren().add(txtTentativas);
        boxHeader.getChildren().add(txtTentativasMax);

        this.getChildren().add(boxHeader);

        getChildren().add(new Separator(Orientation.HORIZONTAL));

        grid = new GridPane();

        int count = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                var keyWordView = new KeyWordView(game.getKeywords().get(count));
                keyWordView.setKeyWordListener(this);
                grid.add(keyWordView, coluna, linha);
                count++;
            }
        }
        var boxGrid = new HBox(grid);
        boxGrid.setAlignment(Pos.CENTER);
        this.getChildren().add(boxGrid);

        var boxSucess = new VBox();
        boxSucess.setMaxHeight(200);
        ListView<Keyword> listViewSucess = new ListView<>();
        listViewSucess.setItems(successfulAttemptsKeyWord);
        var txtTextSuccess = new Text("Acertos");

        boxSucess.getChildren().addAll(txtTextSuccess, listViewSucess);

        var boxUnSucess = new VBox();
        boxUnSucess.setMaxHeight(200);
        ListView<Keyword> listViewUnSucess = new ListView<>();
        listViewUnSucess.setItems(unsuccessfulAttemptsKeyWord);
        var txtTextErros = new Text("Erros");

        boxUnSucess.getChildren().addAll(txtTextErros, listViewUnSucess);

        HBox hboxList = new HBox(boxSucess, boxUnSucess);
        this.getChildren().add(hboxList);
    }


    @Override
    public boolean setAssertKeyWordTheme(Keyword keyword) {
        var acert = keyword.getTheme().getName().equals(game.getTheme());
        if (acert) {
            game.addHit();
            successfulAttemptsKeyWord.add(keyword);
            if (!game.hasNewHit()) {
                endGame(true);
            }
        } else {
            game.addAttempt();
            unsuccessfulAttemptsKeyWord.add(keyword);
            txtTentativas.setText(game.getActualAttempt() + "/");
            if (!game.hasNewAttemp()) {
                endGame(false);
            }
        }
        return acert;
    }

    private void endGame(boolean isSucces) {
        Dialog<Void> dialog;
        if (isSucces) {
            Record record = new Record();
            record.setName(game.getPlayer());
            record.setTimeDuration(timeDuration);
            repository.create(record);

            dialog = new Dialog<>();
            dialog.initOwner(mainWindows.getOwner());

            dialog.setContentText("Parabens!!");
        } else {
            dialog = new Dialog<>();
            dialog.initOwner(mainWindows.getOwner());
            dialog.setContentText("Game Over!!");
        }

        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());

        dialog.showAndWait();

        mainWindows.setScene(new Scene(new MainView(mainWindows)));

    }

}
