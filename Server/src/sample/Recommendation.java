package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gives recommendation of songs to the user
 */
public class Recommendation {

    String input;
    ResultSet resultSet;
    String sql;
    Connectivity.ConnClass connectionClass = new ConnClass();
    Connection connection = connectionClass.getConnection();
    Statement statement;

    String username;

    /**
     * @param username of user
     */
    Recommendation(String username)
    {
        this.username = username;
    }

    /**
     * @return Recommendation by artist
     * @throws SQLException
     */
    public ResultSet byArtist() throws SQLException
    {
        String query="Select Name from Song WHERE SongId = (SELECT SongID FROM songartist WHERE ArtistID = (SELECT ArtistID from userartist where UserID = '"+username+"'))";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return Recommendation by genre
     * @throws SQLException
     */
    public ResultSet byGenre() throws SQLException
    {
        String query="Select Name from Song WHERE SongId = (SELECT SongID FROM songgenre WHERE GenreID = (SELECT ArtistID from usergenre where UserID = '"+username+"'))";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return Recommendation by language
     * @throws SQLException
     */
    public ResultSet byLanguage() throws SQLException
    {
        String query="Select Name from Song WHERE SongId = (SELECT SongID FROM songlang WHERE LangID = (SELECT LangID from userlang where UserID = '"+username+"'))";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return Recommendation by most likes and least dislikes
     * @throws SQLException
     */
    public ResultSet byLikes() throws SQLException
    {
        String query="Select Name from Song SORT BY Likes DESC Dislikes ASC LIMIT 10";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }

    /**
     * @return Recommendation by no. of times played
     * @throws SQLException
     */
    public ResultSet byMostPlayed() throws SQLException
    {
        String query="Select Name from Song SORT BY TimesPlayed DESC LIMIT 10";
        resultSet=statement.executeQuery(query);
        return resultSet;
    }
}
