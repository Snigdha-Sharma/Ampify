package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServerPlaylistSet {
    ArrayList<String> songs;
    String username, playlistName;

    ServerPlaylistSet(List<String> songList, String username, String playlistName)
    {
        this.username=username;
        this.playlistName=playlistName;
        songs=new ArrayList<>();
        for (String x : songList)
        {
            songs.add(x);
        }
    }

    boolean isSuccess() throws SQLException
    {
        boolean created;
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement;
//--------------------------------------------Checking for duplicate name from table--------------------

        String sql="SELECT * FROM playlistuser WHERE USERID = '"+username+"' AND PlaylistName = '"+playlistName+"'";
        statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next())
        {
            return false;
        }
//--------------------------------------------creating new playlist in user-playlist table--------------------
        sql = "INSERT INTO playlistuser(USERID, PlaylistName) VALUES ('"+username+"','"+playlistName+"')";
        statement = connection.createStatement();
        try {
            statement.executeUpdate(sql);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }

//        ------------------------------------Selecting playlist id---------------------------------------
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
//--------------------------------------------Inserting songs into playlist-song table-------------------------
        for(String str : songs)
        {
//-----------------------------         Getting song ID
            String sname = "";
            sql = "SELECT SongId FROM Song WHERE Name='"+str+"'";
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
        }

        return created;
    }
}
