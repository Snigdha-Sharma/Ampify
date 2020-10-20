package sample;

import Connectivity.ConnClass;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;

public class ServerRegisterNewUser
{
    String uname,pwd;
    boolean registered=false;

    ServerRegisterNewUser(String uname,String pwd)
    {
        this.uname=uname;
        this.pwd=pwd;
    }

    boolean isRegisteredSuccessfully() throws SQLException
    {
        Connectivity.ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT * FROM login WHERE Uname = '"+uname+"' AND Passwd = '"+pwd+"';";
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next())
        {
            return false;
        }
        sql="INSERT INTO login(Uname, Passwd) VALUES ('"+uname+"', '"+pwd+"')";
        statement=connection.createStatement();
        try {
            statement.executeUpdate(sql);
            registered=true;
        }
        catch(Exception e){
            registered = false;
        }
        return registered;
    }
}
