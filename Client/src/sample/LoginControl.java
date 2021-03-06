package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * controller class for loginscene.fxml
 */
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

    static Stage window;

    /**
     * initializes all the warning the labels to empty strings
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        warning.setText("");
        warning2.setText("");
        check.setSelected(false);
    }

    /**
     * Fetches login details and creates a login request.
     * @param event onClick
     */
    public void LoginAct(ActionEvent event)
    {
        try
        {
            String u1=uname1.getText();

            String p1=pass1.getText();
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
            p1=generateSecurePassword(p1, "mnnit");
            LoginRequest ob=new LoginRequest(u1,p1);
            ob.myRequest();
            if (ob.isValidUser())
            {
                try
                {
                    UserData.setUname(u1);
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

    /**
     * Fetches register details and sends register request
     * @param event onClick
     * @throws IOException
     */
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
//        else if(u1.indexOf('*')==-1 && u1.indexOf('&')==-1 && u1.indexOf('@')==-1 && u1.indexOf('%')==-1) {
//            warning2.setText("Username should have atleast one special character: *, &, @, %.");
//            uname2.setText("");
//            pass2.setText("");
//            repass.setText("");
//            return;
//        }
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
            warning2.setText("Password should not contain username!");
            uname2.setText("");
            pass2.setText("");
            repass.setText("");
            return;
        }
        if(p1.equals(retype))
        {
            p1=generateSecurePassword(p1, "mnnit");
            RegisterRequest ob=new RegisterRequest(u1,p1);
            ob.myRequest();
            if(ob.isSuccessfullyRegistered())
            {
//                setUname(u1);
                UserData.setUname(u1);
                GoToData();
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

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * Hashes the password to secure it
     * @param password
     * @param salt
     * @return
     */
    public static byte[] hash(char[] password, byte[] salt)
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try
        {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        }
        finally
        {
            spec.clearPassword();
        }
    }

    /**
     * Uses base64 encoding to hash the password
     * @param password
     * @param salt
     * @return
     */
    public static String generateSecurePassword(String password, String salt)
    {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }

    /**
     * Loads new scene with userdetails page
     * @throws IOException
     */
    public void GoToData() throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("UserDetails.fxml"));
        Scene second=new Scene(root1);

        Main.window.setScene(second);
        Main.window.show();
//        warning.setText("Registration Successful! Ready to login.");
    }

    /**
     * Loads new scene with PLAYER HOME page
     * @param event
     * @throws IOException
     */
    public void OpenPlayerHome(ActionEvent event) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        second.getStylesheets().add("resources/css/middle.css");

        window.setScene(second);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - second.getWidth()) * 0.3;
        double y = bounds.getMinY() + (bounds.getHeight() - second.getHeight()) * 0.7;
        Main.window.setX(x);
        Main.window.setY(y);
        window.setOnCloseRequest(e-> {
            try {
                closePlayer();
            } catch (IOException ioException) {
//                ioException.printStackTrace();
            }
        });
        window.show();
    }

    /**
     * Closes media player
     */
    public static void closePlayer() throws IOException {
        Controller.closePlayer();
        Main.window.close();
    }
}
