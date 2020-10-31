package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates playlist and stores in database
 */
public class ServerPlaylistSet {
    ArrayList<String> songs;
    String username, playlistName;

    /**
     * @param songList List of songs in the playlist
     * @param username  username of person creating the playlist
     * @param playlistName  name of playlist
     */
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

    /**
     * @param username for creating default playlists
     * @param playlistName
     */
    ServerPlaylistSet(String username, String playlistName)
    {
        this.username=username;
        this.playlistName=playlistName;
    }

    /**
     * @return if playlist creation was successful after adding data into database
     * @throws SQLException
     */
    boolean isSuccess() throws SQLException {
        boolean created;
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement;
//--------------------------------------------Checking for duplicate name from table--------------------

        String sql = "SELECT * FROM playlistuser WHERE USERID = '" + username + "' AND PlaylistName = '" + playlistName + "'";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return false;
        }
//--------------------------------------------creating new playlist in user-playlist table--------------------
        sql = "INSERT INTO playlistuser(USERID, PlaylistName) VALUES ('" + username + "','" + playlistName + "')";
        statement = connection.createStatement();
        try {
            statement.executeUpdate(sql);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }
        if(playlistName.equals("Liked Songs") || playlistName.equals("Disliked Songs"))
        {
            InsertSongs();
        }
        return created;
    }

    public boolean InsertSongs() throws SQLException
    {
        boolean created=true;
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement;
        String sql;
        ResultSet resultSet;

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
//--------------------------------------------Getting song ID----------------------------------------
        for(String str : songs)
        {
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
//--------------------------------------------Inserting songs into playlist-song table-----------------------
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
