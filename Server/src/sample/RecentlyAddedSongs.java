package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class RecentlyAddedSongs {

    public ResultSet getRs()  throws SQLException {
        Connectivity.ConnClass connectionClass=new ConnClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        ResultSet rs;
        Date date=java.util.Calendar.getInstance().getTime();
        String query="Select Name from Song WHERE DATEDIFF(DateAdded, NOW())<=365";
        rs=statement.executeQuery(query);
//        System.out.println(rs);
        return rs;
    }
}
