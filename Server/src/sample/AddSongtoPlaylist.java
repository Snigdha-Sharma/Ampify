package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddSongtoPlaylist {

    String username, playlistName, songName;


    AddSongtoPlaylist(String songName, String username, String playlistName)
    {
        this.username=username;
        this.playlistName=playlistName;
        this.songName = songName;
    }

    boolean playlistAdd() throws SQLException
    {
        boolean created;
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement;
        ResultSet resultSet;
        String sql;

        String playlistid="";
        sql = "SELECT PlaylistID FROM playlistuser WHERE USERID='"+username+"' AND PlaylistName='"+playlistName+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                playlistid = resultSet.getString(1);
            }
            else {
                created = false;
                return created;
            }
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }

        String sname = "";
        sql = "SELECT SongId FROM Song WHERE Name='"+songName+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                sname = resultSet.getString(1);
            }
            else {
                created = false;
                return created;
            }
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }
        sql = "INSERT INTO playlistsong(PlaylistID, SongID) VALUES ('"+playlistid+"','"+sname+"')";
        statement = connection.createStatement();
        try {
            statement.executeUpdate(sql);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }
        
        return created;
    }

}
