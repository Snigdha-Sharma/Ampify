package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnClass {
    public Connection connection;
    public  Connection getConnection(){
//        String dbName="Ampify";
        String userName="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Ampify?useTimezone=true&serverTimezone=UTC", userName, password);
        }
//        jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
