package sample;


import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Connectivity.ConnClass;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserControl implements Initializable
{
    public Button submit;
    public Label warn;
    public TextField name;
    public TextField email;
    public TextField phn;
    public ChoiceBox state;
    public DatePicker dob;
    public CheckBox pop;
    public CheckBox rap;
    public CheckBox contemp;
    public CheckBox metal;
    public CheckBox folk;
    public CheckBox romantic;
    public CheckBox hiphop;
    public CheckBox brostep;
    public CheckBox regional;
    public CheckBox band;
    public CheckBox rock;
    public CheckBox classical;

    public CheckBox english;
    public CheckBox hindi;
    public CheckBox telugu;
    public CheckBox harayanvi;
    public CheckBox bihari;
    public CheckBox punjabi;
    public CheckBox french;
    public CheckBox spanish;
    public CheckBox tamil;
    public CheckBox marathi;
    public CheckBox gujarati;
    public CheckBox rajasthani;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        String states[]={"Madhya Pradesh", "Uttar Pradesh", "bihar", "Punjab", "Harayana",
                "Chhattisgarh", "Gujarat", "Maharashtra", "Jammu & Kashmir", "Andhra Pradesh",
        "Telangana", "Uttar Pradesh", "Uttarakhand", "North-Eastern States", "Kerela", "Karnataka",
        "Tamil Nadu", "Odisha", "West Bengal"};
        warn.setText("");
        state.setItems(FXCollections.observableArrayList(states));
    }


    public void submitAct(ActionEvent event)
    {
        try {
            String name1 = name.getText();
            String phn1 = phn.getText();
            String email1 = email.getText();
            String state1 = state.getId();

            if(pop.isSelected())
            {

            }
            if(classical.isSelected())
            {

            }
            if(metal.isSelected())
            {

            }
            if(folk.isSelected())
            {

            }
            if(romantic.isSelected())
            {

            }
            if(contemp.isSelected())
            {

            }
            if(rap.isSelected())
            {

            }
            if(brostep.isSelected())
            {

            }
            if(regional.isSelected())
            {

            }
            if(hiphop.isSelected())
            {

            }
            if(band.isSelected())
            {

            }
            if(rock.isSelected())
            {

            }
//            --------------------------------LANGUAGES---------------------------------------
            if(english.isSelected())
            {

            }if(hindi.isSelected())
            {

            }if(punjabi.isSelected())
            {

            }if(harayanvi.isSelected())
            {

            }if(bihari.isSelected())
            {

            }if(telugu.isSelected())
            {

            }if(marathi.isSelected())
            {

            }if(gujarati.isSelected())
            {

            }if(french.isSelected())
            {

            }if(spanish.isSelected())
            {

            }if(rajasthani.isSelected())
            {

            }if(tamil.isSelected())
            {

            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
