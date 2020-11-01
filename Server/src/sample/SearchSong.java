package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * To search songs for user
 */
public class SearchSong {
    String input;
    ResultSet resultSet;
    String sql;
    Connectivity.ConnClass connectionClass = new ConnClass();
    Connection connection = connectionClass.getConnection();
    Statement statement;

    /**
     * @param input input of search by user
     */
    public SearchSong(String input) {
        this.input = input;
    }

    public ResultSet bySongName() throws SQLException
    {
        String query="Select Name from Song WHERE LOCATE('"+input+"', Name) <> 0";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return resultset of search by artist
     * @throws SQLException
     */
    public ResultSet byArtist() throws SQLException
    {
        String artistID="";
        sql = "SELECT ID FROM artist WHERE LOCATE('"+input+"', Artist) <> 0";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                artistID = resultSet.getString(1);
                System.out.println(artistID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query="Select Name from Song INNER JOIN songartist ON Song.SongId=songartist.SongID WHERE ArtistID = '"+artistID+"'";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return resultset of search by genre
     * @throws SQLException
     */
    public ResultSet byGenre() throws SQLException
    {
        String genreID="";
        sql = "SELECT ID FROM genre WHERE LOCATE('"+input+"', Genre) <> 0";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                genreID = resultSet.getString(1);
                System.out.println(genreID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query="Select Name from Song INNER JOIN songgenre ON Song.SongId=songgenre.SongID WHERE GenreID = '"+genreID+"'";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return resultset of search by language
     * @throws SQLException
     */
    public ResultSet byLanguage() throws SQLException
    {
        String langID="";
        sql = "SELECT ID FROM language WHERE LOCATE('"+input+"', Language) <> 0";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                langID = resultSet.getString(1);
                System.out.println(langID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query="Select Name from Song INNER JOIN songlang ON Song.SongId=songlang.SongID WHERE langID = '"+langID+"'";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }
}
