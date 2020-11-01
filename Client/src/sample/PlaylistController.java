package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.CheckListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for playlist creation page
 */
public class PlaylistController implements Initializable
{
    public Label warn;
    public JFXButton backButton;
    public JFXButton doneButton;
    public CheckListView<String> allSongsList;
    public TextField nameOfPlaylist;

    /**
     * initializes the list of songs to be added into playlist
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> observeAllSongs= FXCollections.observableArrayList(MiddlePageController.currPlayList);
        allSongsList.setItems(observeAllSongs);
    }

    /**
     * @throws IOException goes back to home page after successful creation of playlist
     */
    public void goBack() throws IOException
    {
        MiddlePageController.currPlayList=null;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

        Scene second=new Scene(root1);

        Main.window.setScene(second);
        second.getStylesheets().add("resources/css/middle.css");
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.show();



    }

    /**
     * @throws IOException creates new playlist
     */
    public void makePlaylist() throws IOException
    {
        String playlistName=nameOfPlaylist.getText();
        System.out.println(playlistName);
        if(playlistName==null) {
            warn.setText("Playlist name cannot be empty!");
            return;
        }

        System.out.println(playlistName);

        if(playlistName.isEmpty()) {
            warn.setText("Playlist name cannot be empty!");
            return;
        }

        List<String> selectedSongs=allSongsList.getCheckModel().getCheckedItems();

        if(selectedSongs.isEmpty())
        {
            warn.setText("Select atleast one song for the playlist.");
            return;
        }

        NewPlaylistRequest o=new NewPlaylistRequest(playlistName,selectedSongs);

//        System.out.println(UserData.getUname());
        o.myRequest();
        if(!o.isSuccessfullyCreation())
        {
            warn.setText("Playlist name should not match with other playlists!");
            return;
        }
        goBack();
    }

    protected static void closePlayer() throws IOException {
        LogOffRequest lor = new LogOffRequest();
        lor.myRequest();
        System.exit(0);
    }
}
