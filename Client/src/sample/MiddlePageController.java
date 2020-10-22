package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MiddlePageController
{
    public JFXButton allSongsButton;
    public JFXButton localSongsButton;
    public JFXButton refreshLocalSongListButton;
    public static List<String> currPlayList=null;
    public static List<String> localSongsPlaylist=null;
    boolean updated=false;

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

    public void getLocalSongs() throws IOException
    {
        localSongsPlaylist=new ArrayList<>();
        FileInputStream reader= null;
        try
        {
            reader = new FileInputStream("LocalSongs.txt");
        }
        catch (FileNotFoundException e)
        {
            refreshLocalSongList();
            reader=new FileInputStream("LocalSongs.txt");
        }
        Scanner sc=new Scanner(reader);

        while(sc.hasNextLine())
        {
            String path=sc.nextLine();
            //System.out.println("Path:"+path);
            localSongsPlaylist.add(path);
        }
        sc.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        Main.window.setScene(second);
        Main.window.show();
    }

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
    }
}
