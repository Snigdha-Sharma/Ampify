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
        check.setSelected(false);
    }

    public void LoginAct(ActionEvent event)
    {
        try
        {
            String u1=uname1.getText();
            String p1=pass1.getText();
            LoginRequest ob=new LoginRequest(u1,p1);
            ob.myRequest();
            if(!check.isSelected())
            {
                warning.setText("Please verify that you are not a robot.");
                uname1.setText("");
                pass1.setText("");
                return;
            }
            else if(p1.isEmpty())
            {
                warning.setText("Password field empty!");
                uname1.setText("");
                pass1.setText("");
                return;
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

        boolean b=false, c1=false, c2=false, c3=false;
        for(int i=0; i<u1.length(); i++) {
            Character ch = u1.charAt(i);
            if( Character.isDigit(ch)) {
                c1 = true;
            }
            else if (Character.isUpperCase(ch)) {
                c2 = true;
            } else if (Character.isLowerCase(ch)) {
                c3 = true;
            }
            if(c1 && c2 && c3) {
                b = true;
                break;
            }
        }
        if(!b)
        {
            if(!c1)
            {
                warning2.setText("Username should have atleast one digit.");
                uname2.setText("");
                pass2.setText("");
                repass.setText("");
                return;
            }
            if(!c2)
            {
                warning2.setText("Username should have atleast one uppercase letter.");
                uname2.setText("");
                pass2.setText("");
                repass.setText("");
                return;
            }
            if(!c3)
            {
                warning2.setText("Username should have atleast one lowercase letter.");
                uname2.setText("");
                pass2.setText("");
                repass.setText("");
                return;
            }
        }

        if(u1.length()<5)
        {
            warning2.setText("Username size > 5 expected");
            uname1.setText("");
            pass2.setText("");
            repass.setText("");
            return;
        }
        else if(u1.indexOf('*')==-1 && u1.indexOf('&')==-1 && u1.indexOf('@')==-1 && u1.indexOf('%')==-1) {
            warning2.setText("Username should have atleast one special character: *, &, @, %.");
            uname2.setText("");
            pass2.setText("");
            repass.setText("");
            return;
        }
        else if(p1.isEmpty() || retype.isEmpty())
        {
            warning2.setText("Password field empty!");
            uname1.setText("");
            pass2.setText("");
            repass.setText("");
            return;
        }
        else if(p1.contains(u1))
        {
            warning2.setText("Password should not be same as username!");
            uname2.setText("");
            pass2.setText("");
            repass.setText("");
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
                uname2.setText("");
                pass2.setText("");
                repass.setText("");
            }
        }
        else
        {
            warning2.setText("Password and repeat password do not match!");
            uname2.setText("");
            pass2.setText("");
            repass.setText("");
        }
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
