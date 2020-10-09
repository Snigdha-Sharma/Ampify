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
    public Label warning2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        warning.setText("");
        warning2.setText("");
    }
//public void button(ActionEvent actionEvent) throws SQLException {
//    System.out.println(uname1.getText());
//    System.out.println("Program is running");
//}

    public void LoginAct() {
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
            String sql="SELECT * FROM login WHERE Uname = '"+u1+"' AND Passwd = '"+p1+"';";
            ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next()){
                System.out.println("Connected");
            }else {
                warning.setText("Invalid UserId/Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RegisterAct () {
        ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        try {
            String u1=uname2.getText();
            String p1=pass2.getText();
            String retype=repass.getText();
//            System.out.println(u1);
//            System.out.println(p1);
//            System.out.println(retype);
            if(u1.length()<5)
            {
                warning2.setText("Enter a valid Username!");
                return;
            }
            if(p1.equals(retype))
            {
                String sql="INSERT INTO login(Uname, Passwd) VALUES ('"+u1+"', '"+p1+"')";
                Statement statement=connection.createStatement();
                statement.executeUpdate(sql);
            }
            else warning2.setText("Password and repeat password do not match!");
//            System.out.println(p1);
//            System.out.println(retype);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
