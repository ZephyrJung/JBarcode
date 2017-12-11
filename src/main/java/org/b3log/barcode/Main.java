package org.b3log.barcode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.b3log.utils.FileHelper;

public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        FileHelper.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 390));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
