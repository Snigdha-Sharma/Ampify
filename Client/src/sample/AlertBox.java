package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
