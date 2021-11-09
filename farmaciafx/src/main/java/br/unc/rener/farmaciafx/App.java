package br.unc.rener.farmaciafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("farmaciafx/TelaPrincipal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sistema de Farmacia");
        stage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }

}