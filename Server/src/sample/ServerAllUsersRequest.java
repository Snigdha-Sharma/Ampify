package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gets data of all the users registered from the databasa
 */
public class ServerAllUsersRequest
{
    ResultSet rs;

    /**
     * @return gets all the names of users in a list
     * @throws SQLException
     */
    public ResultSet getAllUsersSet() throws SQLException
    {
        Connectivity.ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String query="Select Uname from login";
        rs=statement.executeQuery(query);
        return rs;
    }
}
