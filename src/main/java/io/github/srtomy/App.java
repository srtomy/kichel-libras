package io.github.srtomy;

import io.github.srtomy.builder.KeyWordBuilder;
import io.github.srtomy.connection.Database;
import io.github.srtomy.gui.GameView;
import io.github.srtomy.gui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Database.getInstance().getConnection();

        var scene = new Scene(new MainView(stage));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}