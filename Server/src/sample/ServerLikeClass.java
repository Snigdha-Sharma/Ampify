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

        String played="";
        sql = "SELECT TimesPlayed FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                played = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int play=Integer.parseInt(played);
        play+=1;
        int dislike=0, like=0;

        if(!dislikes.isEmpty())
        {
            dislike=Integer.parseInt(dislikes);
            sql = "UPDATE usersong SET Liked=1, DISLIKED=0 WHERE USERID ='"+uname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if(likes.isEmpty()){
            sql = "INSERT INTO usersong(UserID, SongID, Liked, TimesPlayed) VALUES ('"+uname+"','"+sid+"', 1, 1)";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        like=Integer.parseInt(likes);
//        --------------------------------------------------------------------------------------------
        String dislikessong="";
        sql = "SELECT Dislikes FROM song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                dislikessong = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        int dsong=Integer.parseInt(dislikessong);

        String likessong="";
        sql = "SELECT Likes FROM song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                likessong = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int lsong=Integer.parseInt(likessong);

        if(likes.isEmpty() && dislikes.isEmpty() || (like==0 && dislike==0))
        {
            lsong+=1;
            sql = "UPDATE song SET Likes='"+lsong+"', Dislikes='"+dsong+"' WHERE Name ='"+sname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if(!dislikes.isEmpty()  && dsong>0){
            lsong+=1;
            dsong-=1;
            sql = "UPDATE song SET Likes='"+lsong+"', Dislikes='"+dsong+"' WHERE Name ='"+sname+"'";
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

        String played="";
        sql = "SELECT TimesPlayed FROM usersong WHERE UserID='"+uname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                played = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int play=Integer.parseInt(played);
        play+=1;

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
        int dislike=Integer.parseInt(dislikes);

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
        int like=Integer.parseInt(likes);

        if(!likes.isEmpty())
        {
            sql = "UPDATE usersong SET Liked=0, DISLIKED=1 WHERE USERID ='"+uname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if(dislikes.isEmpty()){
            sql = "INSERT INTO usersong(UserID, SongID, Disliked, TimesPlayed) VALUES ('"+uname+"','"+sid+"', 1, 1)";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//--------------------------------------------------------------------------------------------------------
//        String playedsong="";
//        sql = "SELECT TimesPlayed FROM song WHERE Name='"+sname+"'";
//        statement = connection.createStatement();
//        try {
//            resultSet = statement.executeQuery(sql);
//            if(resultSet.next()){
//                playedsong = resultSet.getString(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        int playsong=Integer.parseInt(played);

        String dislikessong="";
        sql = "SELECT Dislikes FROM song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                dislikessong = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int dsong=Integer.parseInt(dislikessong);

        String likessong="";
        sql = "SELECT Likes FROM song WHERE Name='"+sname+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                likessong = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int lsong=Integer.parseInt(likessong);

        if(likes.isEmpty() && dislikes.isEmpty() || (like==0 && dislike==0))
        {
            dsong+=1;
            sql = "UPDATE song SET Likes='"+lsong+"', Dislikes='"+dsong+"' WHERE Name ='"+sname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if(!likes.isEmpty() && lsong>0){
            lsong-=1;
            dsong+=1;
            sql = "UPDATE song SET Likes='"+lsong+"', Dislikes='"+dsong+"' WHERE Name ='"+sname+"'";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
