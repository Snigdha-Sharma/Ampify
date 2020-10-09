package sample;

import com.jfoenix.controls.JFXSlider;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public Button prevSongButton;
    public Button nextSongButton;
    public Button playPause;
    public Button stop;
    public Button muteUnmuteButton;
    public Button volumeDown;
    public Button volumeUp;
    public Button uploadButton;
    public JFXSlider seekbar;
    public Label duration;

    private MediaView mv;
    String source;
    static volatile Media media;
    static volatile MediaPlayer mediaPlayer;
    Image playButtonImage,pauseButtonImage,muteButtonImage,unmuteButtonImage;
    boolean songPlaying=false;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        source = new File("src\\Songs\\Bang Bang.mp3").toURI().toString();
        media =  new Media(source);
        mediaPlayer = new MediaPlayer(media);
        //mv.setMediaPlayer(mediaPlayer);

        playButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Play.jpg"));
        pauseButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Pause.jpg"));
        muteButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Mute.jpg"));
        unmuteButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\NotMute.jpg"));
        duration.setText("0:00");
    }

    public void uploadSong()
    {
        System.out.println("HEYA!!!");
    }

    public void getToAnySongLocation()
    {
        Double loc=seekbar.getValue();
        mediaPlayer.seek(Duration.millis((loc*media.getDuration().toMillis())/100));
    }

    public void goToPrevSong()
    {

    }

    public void setNextSongButton()
    {

    }

    public void muteOrUnmute()
    {
        if (mediaPlayer.isMute()==true)
        {
            muteUnmuteButton.setGraphic(new ImageView(unmuteButtonImage));
            mediaPlayer.setMute(false);
        }
        else
        {
            muteUnmuteButton.setGraphic(new ImageView(muteButtonImage));
            mediaPlayer.setMute(true);
        }
    }

    public void playOrPause()
    {
        if (mediaPlayer.getStatus()== MediaPlayer.Status.PLAYING)
        {
            playPause.setGraphic(new ImageView(playButtonImage));
            mediaPlayer.pause();
        }
        else
        {
            playPause.setGraphic(new ImageView(pauseButtonImage));
            mediaPlayer.play();
            System.out.println(media.getMetadata());
            if (songPlaying==false)
            {
                songPlaying=true;
                System.out.println(media.getTracks());
                long insec= (long) media.getDuration().toSeconds();
                long min=insec/60;
                long sec=insec%60;
                sec=Math.round((sec*100.0)/100.0);
                duration.setText(min+":"+sec);
            }
        }
    }

    public void stopCurrSong()
    {
        mediaPlayer.stop();
        songPlaying=false;
        playPause.setGraphic(new ImageView(playButtonImage));
        duration.setText("0:00");
    }

    public void increaseVolume()
    {
        if (mediaPlayer.getVolume()<1.0)
        {
            mediaPlayer.setVolume(mediaPlayer.getVolume()+0.125);
        }
    }

    public void decreaseVolume()
    {
        if (mediaPlayer.getVolume()>0)
        {
            mediaPlayer.setVolume(mediaPlayer.getVolume()-0.125);
        }
    }
}
