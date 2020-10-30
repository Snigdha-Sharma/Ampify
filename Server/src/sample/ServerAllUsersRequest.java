package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerAllUsersRequest
{
    ResultSet rs;

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
