package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlertBox implements Initializable
{
    public Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        final LocalSongsService service=new LocalSongsService();
        label.setText(service.getTitle());
        service.start();
        System.out.println("Service Started");
    }
}
