package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    public static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        window.setTitle("Login/Register");
        window.setOpacity(0.9); //new
        Scene scene=new Scene(root);
        scene.getStylesheets().add("resources/css/middle.css");
        window.setScene(scene);

        window.setOnCloseRequest(e->closeProgram());
        window.show();
    }

    private void closeProgram()
    {
        window.close();
    }
    
}
