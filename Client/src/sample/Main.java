package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public static Stage window;
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

    public static void main(String[] args) {
        launch(args);
    }
}
