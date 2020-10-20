package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerAllSongsRequest
{
    ResultSet rs;

    public ResultSet getAllSongsSet() throws SQLException
    {
        Connectivity.ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String query="Select Name from Song";
        rs=statement.executeQuery(query);
        System.out.println("Result set returned");
        return rs;
    }
}
