package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerLikeClass {
    String uname, sname, sql;
    boolean created;
    Connectivity.ConnClass connectionClass = new ConnClass();
    Connection connection = connectionClass.getConnection();
    Statement statement;
    ResultSet resultSet;

    ServerLikeClass(String uname, String sname)
    {
        this.uname = uname;
        this.sname = sname;
    }

    public void likeStore() throws SQLException
    {
        String sid="";
        sql = "SELECT SongId FROM Song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                sid = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String likes="";
        sql = "SELECT Liked FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                likes = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dislikes="";
        sql = "SELECT Disliked FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                dislikes = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!dislikes.isEmpty())
        {
            sql = "UPDATE usersong SET Liked=1 AND DISLIKED=0 WHERE USERID ='"+uname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(likes.isEmpty()){
            sql = "INSERT INTO usersong(UserID, SongID, Liked, TimesPlayed) VALUES ('"+uname+"','"+sid+"', 1, 1)";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dislikeStore() throws SQLException
    {
        String sid="";
        sql = "SELECT SongId FROM Song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                sid = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dislikes="";
        sql = "SELECT Disliked FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                dislikes = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String likes="";
        sql = "SELECT Liked FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                likes = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!likes.isEmpty())
        {
            sql = "UPDATE usersong SET Liked=0 AND DISLIKED=1 WHERE USERID ='"+uname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(dislikes.isEmpty()){
            sql = "INSERT INTO usersong(UserID, SongID, Disliked, TimesPlayed) VALUES ('"+uname+"','"+sid+"', 1, 1)";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
