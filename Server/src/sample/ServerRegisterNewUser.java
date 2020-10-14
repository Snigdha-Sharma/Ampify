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
        pwd=generateSecurePassword(pwd, "mnnit");
        String sql="SELECT * FROM login WHERE Uname = '"+uname+"' AND Passwd = '"+pwd+"';";
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next())
        {
            return false;
        }
        sql="INSERT INTO login(Uname, Passwd) VALUES ('"+uname+"', '"+pwd+"')";
        statement=connection.createStatement();
        statement.executeUpdate(sql);
        registered=true;
        return registered;
    }

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

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
    public static String generateSecurePassword(String password, String salt)
    {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }

}
