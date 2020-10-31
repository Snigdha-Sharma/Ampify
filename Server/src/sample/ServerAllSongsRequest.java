package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gets names of all songs from the database
 */
public class ServerAllSongsRequest
{
    ResultSet rs;

    /**
     * @return all songs in list format
     * @throws SQLException
     */
    public ResultSet getAllSongsSet() throws SQLException
    {
        Connectivity.ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String query="Select Name from Song";
        rs=statement.executeQuery(query);
        return rs;
    }
}
