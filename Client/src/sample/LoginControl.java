package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Connectivity.ConnClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LoginControl implements Initializable
{
    public Button signup;
    public Button login;
    public TextField uname1;
    public TextField uname2;
    public PasswordField pass1;
    public PasswordField pass2;
    public PasswordField repass;
    public CheckBox check;
    public Label warning;//Login
    public Label warning2;//Register

    Stage window;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        warning.setText("");
        warning2.setText("");
    }

    public void LoginAct(ActionEvent event)
    {
        try
        {
            String u1=uname1.getText();
            String p1=pass1.getText();
            LoginRequest ob=new LoginRequest(u1,p1);
            ob.myRequest();
            if(u1.length()<5)
            {
                warning.setText("Enter a valid Username!");
            }

            if (ob.isValidUser()==true)
            {
                try
                {
                    OpenPlayerHome(event);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                warning.setText("Invalid UserId/Password");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void RegisterAct (ActionEvent event) throws IOException
    {
        String u1=uname2.getText();
        String p1=pass2.getText();
        String retype=repass.getText();

        if(u1.length()<5)
        {
            warning2.setText("Enter a valid Username!");
            return;
        }
        if(p1.equals(retype))
        {
            RegisterRequest ob=new RegisterRequest(u1,p1);
            ob.myRequest();
            if(ob.isSuccessfullyRegistered()==true)
            {
                GoToLogin(event);
            }
            else
            {
                warning2.setText("User already exists!");
            }
        }
        else warning2.setText("Password and repeat password do not match!");
    }

    public void GoToLogin(ActionEvent event) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("loginscene.fxml"));
        Scene second=new Scene(root1);
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(second);
        window.show();
        warning.setText("Registration Successful! Ready to login.");
    }

    public void OpenPlayerHome(ActionEvent event) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(second);
        window.show();
        window.setOnCloseRequest(e->closePlayer());
    }

    private void closePlayer()
    {
        Controller.closePlayer();
        window.close();
    }
}
