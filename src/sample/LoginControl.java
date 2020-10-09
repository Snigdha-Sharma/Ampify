package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Connectivity.ConnClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

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
    public Label warning;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        warning.setText("");
    }
//public void button(ActionEvent actionEvent) throws SQLException {
//    System.out.println(uname1.getText());
//    System.out.println("Program is running");
//}

    public void LoginAct(ActionEvent actionEvent) {
        ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        try {
            Statement statement=connection.createStatement();
            String u1=uname1.getText();
            String p1=pass1.getText();
            if(u1.length()<5)
            {
                warning.setText("Enter a valid Username!");
            }
            String sql="SELECT * FROM login WHERE username = '"+u1+"' AND password = '"+p1+"';";
            ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next()){
                System.out.println("Connected");
            }else {
                System.out.println("Invalid UserId/Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RegisterAct (ActionEvent actionEvent) {
        ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        try {
            String u1=uname1.getText();
            String p1=pass1.getText();
            String retype=pass2.getText();
            if(u1.length()<5)
            {
                warning.setText("Enter a valid Username!");
                return;
            }
            if(p1!=retype || p1.length()<5)
            {
                warning.setText("Enter a valid Password!");
                return;
            }
            String sql="INSERT INTO Login VALUES ('"+u1+"', '"+p1+"')";
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
