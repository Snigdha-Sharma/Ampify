package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlaylistController implements Initializable
{

    public JFXButton backButton;
    public JFXButton doneButton;
    public CheckListView<String> allSongsList;
    public TextField nameOfPlaylist;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> observeAllSongs= FXCollections.observableArrayList(MiddlePageController.currPlayList);
        allSongsList.setItems(observeAllSongs);
    }

    public void goBack() throws IOException
    {
        MiddlePageController.currPlayList=null;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        Main.window.setScene(second);
        Main.window.show();
    }

    public void makePlaylist() throws IOException
    {
        String playlistName=nameOfPlaylist.getText();
        List<String> selectedSongs=allSongsList.getCheckModel().getCheckedItems();
        NewPlaylistRequest o=new NewPlaylistRequest(playlistName,selectedSongs);
        o.myRequest();
        goBack();
    }

}
