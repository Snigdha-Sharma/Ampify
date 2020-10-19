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

public class ServerLoginRequest
{
    String uname,pwd;

    ServerLoginRequest(String uname,String pwd)
    {
        this.uname=uname;
        this.pwd=pwd;
    }

    public boolean isValidUser()
    {
        Connectivity.ConnClass connectionClass=new ConnClass();//Connection through JDBC driver to database
        Connection connection=connectionClass.getConnection();
        try
        {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM login WHERE Uname = '"+uname+"' AND Passwd = '"+pwd+"';";
            ResultSet resultSet=statement.executeQuery(sql);
            if (resultSet.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return false;
    }

}
