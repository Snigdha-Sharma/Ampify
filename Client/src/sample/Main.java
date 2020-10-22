package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main extends Application
{
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("loginscene.fxml"));
        window.setTitle("Login/Register");
        window.setScene(new Scene(root, 800, 500));
        window.setOnCloseRequest(e->closeProgram());
        window.show();
    }

    private void closeProgram()
    {
        window.close();
    }
    
}
