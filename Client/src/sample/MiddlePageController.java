package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;

import java.io.IOException;
import java.util.List;

public class MiddlePageController
{
    JFXButton allSongsButton;
    JFXButton localSongsButton;
    public static List<String> currPlayList=null;

    public void getAllSongs() throws IOException
    {
        AllSongsRequest asr=new AllSongsRequest();
        asr.myRequest();
        currPlayList=asr.allSongsList();
        System.out.println("Curr Playlist has songs now");
        //ObservableList<String> observeAllSongs= FXCollections.observableArrayList(allSongs);
//        Controller.SongList.setItems(observeAllSongs);
//        Controller.SongList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene second=new Scene(root1);
        //window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Main.window.setScene(second);
        Main.window.show();
    }

}
