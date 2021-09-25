package io.github.srtomy.gui;

import io.github.srtomy.builder.KeyWordBuilder;
import io.github.srtomy.model.Record;
import io.github.srtomy.repository.RecordRepository;
import io.github.srtomy.service.RecordRepositoryService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class MainView extends VBox {
    private final Stage mainWindows;
    private final RecordRepository recordRepository = new RecordRepositoryService();
    Button btnNewGame = new Button("Novo Jogo");

    public MainView(Stage mainWindows) {
        this.mainWindows = mainWindows;
        initLayout();

        initActions();
    }

    private void initActions() {
        btnNewGame.setOnAction(evt -> {
            showNewGameInstance();
        });
    }

    private void initLayout() {
        var header = new HBox();


        var lblHeader = new Label("Recordes");
        lblHeader.setFont(Font.font(null, FontWeight.BOLD, 25));
        header.getChildren().add(lblHeader);

        getChildren().add(header);

        getChildren().add(btnNewGame);

        var table = new TableView<Record>();
        var tableColumnName = new TableColumn<Record, String>("Nome");
        var tableColumnTime = new TableColumn<Record, String>("Tempo");

        tableColumnName.setCellValueFactory(evt -> new ReadOnlyStringWrapper(evt.getValue().getName()));

        tableColumnTime.setCellValueFactory(evt -> {
            long millis = evt.getValue().getTimeDuration();
            String hms = String.format("%02d:%02d:%02d", TimeUnit
                            .MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            return new ReadOnlyStringWrapper(hms);
        });


        table.getColumns().add(tableColumnName);
        table.getColumns().add(tableColumnTime);

        table.setItems(FXCollections.observableList(recordRepository.findTopRecords()));

        getChildren().add(table);

    }

    private void showNewGameInstance() {
        var view = new GameView(KeyWordBuilder.build());
        mainWindows.setScene(new Scene(view));
    }
}
