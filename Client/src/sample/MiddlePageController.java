package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controller for home page
 */
public class MiddlePageController
{
    public static List<String> currHistory=null;
    public JFXButton allSongsButton;
    public JFXButton localSongsButton;
    public JFXButton refreshLocalSongListButton;
    public JFXButton playlistButton;
    public JFXButton groupButton;
    public JFXButton downloadedSongsButton;
    public JFXButton latestSongsButton;
    public static List<String> currPlayList=null;
    public static List<String> allUserList=null;
    public static List<String> localSongsPlaylist=null;
    public static List<String> downloadedSongsPlaylist=null;
    public static List<String> searchResultPlaylist=null;
    public static List<String> latestSongsPlaylist=null;
    public static List<String> history=new ArrayList<>();
    public JFXTextField searchBar;
    public JFXButton searchBarInput;

    /**
     * @throws IOException get list of all songs
     */
    public void getAllSongs() throws IOException
    {
        AllSongsRequest asr=new AllSongsRequest();
        asr.myRequest();
        currPlayList=asr.allSongsList();
        System.out.println("All Songs Playlist");
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        //window = (Stage)((Node)event.getSource()).getScene().getWindow();
        second.getStylesheets().add("resources/css/sample.css");
        Main.window.setScene(second);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - second.getWidth()) * 0.3;
        double y = bounds.getMinY() + (bounds.getHeight() - second.getHeight()) * 0.7;
        Main.window.setX(x);
        Main.window.setY(y);
        Main.window.show();
    }

    public void getLatestSongs() throws IOException
    {
        LatestSongsRequest lsr=new LatestSongsRequest();
        lsr.myRequest();
        latestSongsPlaylist=lsr.getLatestSongs();
        System.out.println("Recenet Songs Playlist");
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        second.getStylesheets().add("resources/css/sample.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();
    }

    public void playDownloadedSongs() throws IOException
    {
        File directoryPath=new File(".\\src\\DownloadedSongs");
        File songs[]=directoryPath.listFiles();
        downloadedSongsPlaylist=new ArrayList<>();
        for (File x:songs)
        {
            downloadedSongsPlaylist.add(String.valueOf(x));
            System.out.println(x);
        }
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        second.getStylesheets().add("resources/css/sample.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();
    }

    /**
     * @throws IOException invokes page for creating new playlist
     */
    public void createPlaylist() throws IOException
    {
        AllSongsRequest asr=new AllSongsRequest();
        asr.myRequest();
        currPlayList=asr.allSongsList();
        Parent root1 = FXMLLoader.load(getClass().getResource("SongsForPlaylist.fxml"));
        Scene second=new Scene(root1);
//        Main.window.setScene(second);
        second.getStylesheets().add("resources/css/playlistmake.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();


        Main.window.show();
    }

    /**
     * @throws IOException Gets songs from local machine into a file.txt to play
     */
    public void getLocalSongs() throws IOException
    {
        localSongsPlaylist=new ArrayList<>();
        FileInputStream reader= null;
        File file;
        try
        {
            file=new File("LocalSongs.txt");
            reader = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            refreshLocalSongList();
            file=new File("LocalSongs.txt");
            reader=new FileInputStream(file);
        }

        if (file.length()==0)
        {
            Alert a=new Alert(Alert.AlertType.NONE);
            a.setHeaderText("Alert!");
            a.setContentText("Your local song list is empty. Please refresh to get local songs!");
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.showAndWait();
            return;
        }
        Scanner sc=new Scanner(reader);

        while(sc.hasNextLine())
        {
            String path=sc.nextLine();
            localSongsPlaylist.add(path);
        }
        sc.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
//
//        Main.window.setScene(second);
//        Main.window.show();
        second.getStylesheets().add("resources/css/sample.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();
    }

    /**
     * @throws IOException refreshes local songs list
     */
    public void refreshLocalSongList() throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
        Scene second=new Scene(root1);
        Stage progressStage=new Stage();
        progressStage.setHeight(400);
        progressStage.setWidth(550);
        progressStage.setScene(second);
        progressStage.initModality(Modality.APPLICATION_MODAL);
        progressStage.showAndWait();
        root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        second=new Scene(root1);
//        Main.window.setScene(second);
//        Main.window.show();
        second.getStylesheets().add("resources/css/sample.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();
    }

    /**
     * @throws IOException invokes page to create new users group
     */
    public void makeUserGroup() throws IOException
    {
        AllUsersRequest aur=new AllUsersRequest();
        aur.myRequest();
        allUserList=aur.allUsersList();
        Parent root1 = FXMLLoader.load(getClass().getResource("UserGroupsCreation.fxml"));
        Scene second=new Scene(root1);
//        Main.window.setScene(second);
//        Main.window.show();
        second.getStylesheets().add("resources/css/playlistmake.css");
        Main.window.setScene(second);
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();
    }

    public void customSearch() throws IOException
    {
        String input = searchBar.getText();
        SearchRequest sr = new SearchRequest(input);
        sr.myRequest();
        searchResultPlaylist = sr.searchResult();
        for (String x : searchResultPlaylist)
        {
            System.out.println(x);
        }
    }

    protected static void closePlayer() throws IOException {
        LogOffRequest lor = new LogOffRequest();
        lor.myRequest();
        System.exit(0);
    }
}
