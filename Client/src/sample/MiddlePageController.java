package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
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
    public JFXButton allSongsButton;
    public JFXButton localSongsButton;
    public JFXButton refreshLocalSongListButton;
    public static List<String> currPlayList=null;
    public static List<String> allUserList=null;
    public static List<String> localSongsPlaylist=null;
    public JFXButton playlistButton;
    public JFXButton groupButton;

    /**
     * @throws IOException get list of all songs
     */
    public void getAllSongs() throws IOException
    {
        AllSongsRequest asr=new AllSongsRequest();
        asr.myRequest();
        currPlayList=asr.allSongsList();
        System.out.println("Curr Playlist has songs now");
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        //window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Main.window.setScene(second);
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
        Main.window.setScene(second);


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
        Main.window.setScene(second);
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
        Main.window.setScene(second);
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
        Main.window.setScene(second);
        Main.window.show();
    }
}
