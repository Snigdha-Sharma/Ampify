package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogOffRequest {
    String uname;

    LogOffRequest(String uname)
    {
        this.uname=uname;
    }
    public boolean setLogout() throws SQLException
    {
        Connectivity.ConnClass connectionClass=new ConnClass();//Connection through JDBC driver to database
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String sql="UPDATE TABLE login SET Active=1 WHERE Uname = '"+uname+"'";
        statement=connection.createStatement();
        try {
            statement.executeUpdate(sql);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
