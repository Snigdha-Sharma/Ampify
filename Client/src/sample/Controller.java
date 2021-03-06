package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.util.Duration;

import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.Thread.sleep;
import java.io.File;

public class Controller implements Initializable
{
    public JFXButton prevSongButton;
    public JFXButton nextSongButton;
    public JFXButton playPause;
    public JFXButton stop;
    public JFXButton muteUnmuteButton;
    public JFXButton volumeDown;
    public JFXButton volumeUp;
    public JFXButton uploadButton;
    public JFXButton logOffButton;
    public JFXButton goBackButton;
    public JFXButton downloadButton;
    public JFXButton shuffleButton;
    public JFXButton repeatButton;
    public JFXSlider seekbar;
    public Label duration;
    public Label songName;
    public Label lyrics;
    public ListView<String> SongList;
    public ListView<String> History;
    public int sync=0;
    public Label diff;


    String repeatMode="None";
    int currIdx=-1;

    public MediaView mv;
    String source;
    public Media media;
    public MediaPlayer mediaPlayer;
    Image playButtonImage,pauseButtonImage,muteButtonImage,unmuteButtonImage,shuffleButtonOn,shuffleButtonOff,repeatSongImage,repeatPlaylistImage,repeatOffImage;
    boolean songPlaying=false,isLocal=false,isShuffleOn=false,isDownloaded=false,isLatest=false,isAllSongs=false,isCustom=false,isRecommended=false;
    Thread currSong;
    HashMap<String,String> localSongMap,downloadedSongMap;
    List<String> allSongs;
    TreeMap<Integer,String> lyricsMap;
//    List<String> history=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        createCurrSongList();
        playButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Play.jpg"));
        pauseButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Pause.jpg"));
        muteButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\Mute.jpg"));
        unmuteButtonImage=new Image(getClass().getResourceAsStream("..\\Images\\NotMute.jpg"));
        shuffleButtonOn=new Image(getClass().getResourceAsStream("..\\Images\\ShuffleOn.jpg"));
        shuffleButtonOff=new Image(getClass().getResourceAsStream("..\\Images\\Shuffle.jpg"));
        repeatOffImage=new Image(getClass().getResourceAsStream("..\\Images\\RepeatPlaylist.jpg"));
        repeatSongImage=new Image(getClass().getResourceAsStream("..\\Images\\RepeatSong.jpg"));
        repeatPlaylistImage=new Image(getClass().getResourceAsStream("..\\Images\\RepeatOn.jpg"));

        seekbar.setValue(0);
        duration.setText("0:00");

        ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
        History.setItems(observeHistory);
        History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void goBackToMiddlePage() throws IOException
    {
        if (mediaPlayer!=null)
        {
            mediaPlayer.pause();
        }
        MiddlePageController.currPlayList=null;
        MiddlePageController.downloadedSongsPlaylist=null;
        MiddlePageController.localSongsPlaylist=null;
        MiddlePageController.latestSongsPlaylist=null;
        MiddlePageController.recommendationsList=null;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        Main.window.setScene(second);
        second.getStylesheets().add("resources/css/middle.css");
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - second.getWidth()) * 0.3;
        double y = bounds.getMinY() + (bounds.getHeight() - second.getHeight()) * 0.7;
        Main.window.setX(x);
        Main.window.setY(y);
        Main.window.show();
    }

    public String extractSongName(String path)
    {
        String name = null;
        int len=path.length(),i=len-1;
        while(i>0)
        {
            if (path.charAt(i)=='\\' || path.charAt(i)=='/')
            {
                name=path.substring(i+1,len-4);
                break;
            }
            i--;
        }
        return name;
    }

    public void downloadSongs()
    {
        String fileURL=allSongs.get(currIdx);
        fileURL=getPathForHostedSong(fileURL);
        //System.out.println("Current Directory:"+System.getProperty("user.dir"));
        String saveDir = ".\\src\\DownloadedSongs";
        try
        {
            String fileName = HttpDownloadUtility.downloadFile(fileURL, saveDir);

            String saveFilePath = saveDir + File.separator + fileName;
            String key = "SPK CofnCode CnC";
            File inputFile = new File(saveFilePath);
            File encryptedFile = new File(saveFilePath);

            try {
                CryptoUtils.encrypt(key, inputFile, encryptedFile);
            } catch (CryptoException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void shuffleSongs()
    {
        if (isShuffleOn==false && repeatMode!="Song")
        {
            isShuffleOn=true;
            shuffleButton.setGraphic(new ImageView(shuffleButtonOn));
        }
        else
        {
            isShuffleOn=false;
            shuffleButton.setGraphic(new ImageView(shuffleButtonOff));
        }
    }

    public void repeat()
    {
        if (repeatMode=="None")
        {
            repeatMode="Playlist";
            repeatButton.setGraphic(new ImageView(repeatPlaylistImage));
        }
        else if (repeatMode=="Playlist")
        {
            repeatMode="Song";
            repeatButton.setGraphic(new ImageView(repeatSongImage));
            //If repeat mode was changed to that particular song then turn off shuffling for that playlist if applied
            if (isShuffleOn)
            {
                shuffleSongs();
            }
        }
        else if (repeatMode=="Song")
        {
            repeatMode="None";
            repeatButton.setGraphic(new ImageView(repeatOffImage));
        }
    }

    public void createCurrSongList()
    {
        if (MiddlePageController.currPlayList!=null)
        {
            allSongs=MiddlePageController.currPlayList;
            isAllSongs=true;
        }
        else if (MiddlePageController.downloadedSongsPlaylist!=null)
        {
            allSongs=new ArrayList<>();
            downloadedSongMap=new HashMap<>();
            String name=null;
            for (String path:MiddlePageController.downloadedSongsPlaylist)
            {
                name=extractSongName(path);
                allSongs.add(name);
                downloadedSongMap.put(name,path);
            }
            isDownloaded=true;
        }
        else if (MiddlePageController.localSongsPlaylist!=null)
        {
            allSongs=new ArrayList<>();
            localSongMap=new HashMap<>();
            String name=null;
            for (String path:MiddlePageController.localSongsPlaylist)
            {
                name=extractSongName(path);
                allSongs.add(name);
                localSongMap.put(name,path);
            }
            isLocal=true;
        }
        else if (MiddlePageController.latestSongsPlaylist!=null)
        {
            allSongs=MiddlePageController.latestSongsPlaylist;
            isLatest=true;
        }
        else if (MiddlePageController.customSearchPlaylist!=null)
        {
            allSongs=MiddlePageController.customSearchPlaylist;
            isCustom=true;
        }
        else if (MiddlePageController.recommendationsList!=null)
        {
            allSongs=MiddlePageController.recommendationsList;
            isRecommended=true;
        }
        ObservableList<String> observeAllSongs=FXCollections.observableArrayList(allSongs);
        SongList.setItems(observeAllSongs);
        SongList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void setSongOnPlayer(String s) throws IOException
    {
        System.out.println("Selecting song:"+s);

        if (isAllSongs || isLatest || isCustom || isRecommended)
        {
            int len=s.length();
            String fileURL=s.substring(0,len-4);
            fileURL=fileURL+".srt";
            //System.out.println("Current Directory:"+System.getProperty("user.dir"));
            String saveDir = ".\\src\\SongInfo";
            try
            {
                HttpDownloadUtility.downloadFile(fileURL, saveDir);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            saveDir=saveDir+"\\"+extractSongName(fileURL)+".srt";
            SrtParser temp=new SrtParser(saveDir);
            lyricsMap=temp.setup();
            lyricsMap.put(0,"");
            //System.out.println(lyricsMap);
        }

        media=new Media(s);
        mediaPlayer = new MediaPlayer(media);
        playOrPause();
        mv.setMediaPlayer(mediaPlayer);
        seekbar.setValue(0);
//        AudioEqualizer ae = mediaPlayer.getAudioEqualizer();
//        if(ae!=null)
//        {
//            ae.setEnabled(true);
//        }
//        if(ae.isEnabled()){
//            EqualizerBand eb = new EqualizerBand();
//            ObservableList<EqualizerBand> l = ae.getBands();
//            for (EqualizerBand i: l) {
////                String p = i.toString();
//                System.out.println(i.getBandwidth());
//            }
//            System.out.println(l.toString());
//        }
    }

    public String getPathForLocalSong(String s)
    {
        s=localSongMap.get(s);
        s=new File(s).toURI().toString();
        return s;
    }

    public String getPathForHostedSong(String s)
    {
        s=s.replaceAll("\\s", "");
        s="http://localhost:8080/"+s+".mp3";
        return s;
    }

    private String getPathForDownloadedSong(String s) throws CryptoException
    {
        s=downloadedSongMap.get(s);
        s=new File(s).toURI().toString();
        int i=s.indexOf('.');
        String str = s.substring(i);

        String key = "SPK CofnCode CnC";
        File inputFile = new File(str);
        File decryptedFile = new File(str);
        CryptoUtils.decrypt(key,inputFile,decryptedFile);
        return s;
    }

    public void selectSong() throws IOException, CryptoException {
        source=SongList.getSelectionModel().getSelectedItem();
        songName.setText(source);
        currIdx=SongList.getSelectionModel().getSelectedIndex();
        //SongList.getSelectionModel().clearSelection();
        if (mediaPlayer!=null)
        {
            stopCurrSong();
        }
        if (isAllSongs || isLatest || isCustom || isRecommended)
        {
            source=getPathForHostedSong(source);
        }
        else if (isDownloaded)
        {
            source=getPathForDownloadedSong(source);
        }
        else if (isLocal)
        {
            source=getPathForLocalSong(source);
        }
        setSongOnPlayer(source);

        String name=extractSongName(source);
        MiddlePageController.history.add(name);
        ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
        History.setItems(observeHistory);
        History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        System.out.println("name = "+extractSongName(source));
    }

    public void uploadSong()
    {
        if (mediaPlayer.getStatus()== MediaPlayer.Status.PLAYING)
        {
            playPause.setGraphic(new ImageView(playButtonImage));
            mediaPlayer.pause();
        }
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Open a mp3/mp4 file");
        File selectedFile=fileChooser.showOpenDialog(null);
        source=new File(String.valueOf(selectedFile.getAbsoluteFile())).toURI().toString();
        playPause.setGraphic(new ImageView(playButtonImage));
        media=new Media(source);
        mediaPlayer=new MediaPlayer(media);
        mv.setMediaPlayer(mediaPlayer);
    }

    public void logOff() throws IOException
    {
        LogOffRequest ob=new LogOffRequest();
        ob.myRequest();
        LoginControl.closePlayer();
    }

    /**
     * Implementing seekbar logic
     */
    synchronized public void getToAnySongLocation()
    {
        if (mediaPlayer.getStatus()==MediaPlayer.Status.PAUSED)
        {
            mediaPlayer.play();
            playPause.setGraphic(new ImageView(pauseButtonImage));
        }
        Double loc=seekbar.getValue();
        mediaPlayer.seek(Duration.millis((loc*media.getDuration().toMillis())/100));
        long insec= (long) mediaPlayer.getCurrentTime().toSeconds();
        long min=insec/60;
        long sec=insec%60;
        if (sec/10==0)
        {
            duration.setText(min+":0"+sec);
        }
        else
        {
            sec=Math.round((sec*100.0)/100.0);
            duration.setText(min+":"+sec);
        }
    }

    /**
     * Previous media button in the media player
     */
    public void goToPrevSong() throws IOException, CryptoException {
        if (mediaPlayer!=null)
        {
            stopCurrSong();
        }
        //System.out.println("Currently playing media source:"+allSongs.get(currIdx-1));
        currIdx=currIdx-1;
        if (currIdx>=0)
        {
            if (isLocal)
            {
                System.out.println("Prev Song:"+allSongs.get(currIdx));
                setSongOnPlayer(getPathForLocalSong(allSongs.get(currIdx)));
            }
            else if (isDownloaded)
            {
                setSongOnPlayer(getPathForDownloadedSong(allSongs.get(currIdx)));
            }
            else//isAllSongs,isCustom,isLatest,isRecommended
            {
                setSongOnPlayer(getPathForHostedSong(allSongs.get(currIdx)));
            }
        }
    }

    /**
     * @throws IOException -Go to next media
     */
    public void goToNextSong() throws IOException, CryptoException {
        if (mediaPlayer!=null)
        {
            stopCurrSong();
        }
        System.out.println("Current Index:"+currIdx+"Song List Size:"+allSongs.size());
        currIdx=currIdx+1;
        if (currIdx>=allSongs.size())
        {
            if (repeatMode=="Playlist")
            {
                currIdx=0;
            }
            else if (repeatMode=="Song")
            {
                currIdx=currIdx-1;
            }
            else
            {
                return;
            }
        }
        if (isLocal==true)
        {
            setSongOnPlayer(getPathForLocalSong(allSongs.get(currIdx)));
            String source=getPathForLocalSong(allSongs.get(currIdx));
            String name=extractSongName(source);
            MiddlePageController.history.add(name);
            ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
            History.setItems(observeHistory);
            History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
        else if (isDownloaded==true)
        {
            setSongOnPlayer(getPathForDownloadedSong(allSongs.get(currIdx)));
            String source=getPathForDownloadedSong(allSongs.get(currIdx));
            String name=extractSongName(source);
            MiddlePageController.history.add(name);
            ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
            History.setItems(observeHistory);
            History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
        else
        {
            setSongOnPlayer(getPathForHostedSong(allSongs.get(currIdx)));
            String source=getPathForHostedSong(allSongs.get(currIdx));
            String name=extractSongName(source);
            MiddlePageController.history.add(name);
            ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
            History.setItems(observeHistory);
            History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
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
        if (media==null)
        {
            return;
        }
        if (mediaPlayer.getStatus()== MediaPlayer.Status.PLAYING)
        {
            playPause.setGraphic(new ImageView(playButtonImage));
            mediaPlayer.pause();
        }
        else
        {
            playPause.setGraphic(new ImageView(pauseButtonImage));
            if (songPlaying==false)
            {
                songPlaying=true;
                currSong=new Thread(this::updateCurrSongLoc);
                currSong.start();
            }
            mediaPlayer.play();
            //System.out.println(media.getMetadata());
        }
    }

    public void setRandomSong() throws IOException, CryptoException {
        int len=allSongs.size()-1;
        currIdx=(int)(Math.random()*len);
        if (isLocal==true)
        {
            setSongOnPlayer(getPathForLocalSong(allSongs.get(currIdx)));
        }
        else if (isDownloaded==true)
        {
            setSongOnPlayer(getPathForDownloadedSong(allSongs.get(currIdx)));
        }
        else
        {
            setSongOnPlayer(getPathForHostedSong(allSongs.get(currIdx)));
        }
    }

    public void updateCurrSongLoc()
    {
        while(songPlaying)
        {
            Platform.runLater(()->
            {
                seekbar.setValue((mediaPlayer.getCurrentTime().toSeconds()/ media.getDuration().toSeconds()) *100);
                songName.setText((String) media.getMetadata().get("title"));
                long insec= (long) mediaPlayer.getCurrentTime().toSeconds();
                if (isLocal==false && isDownloaded==false)
                {
                    String l=lyricsMap.get(lyricsMap.floorKey((int) (sync+insec)));
                    lyrics.setText(l);
                }
                long min=insec/60;
                long sec=insec%60;
                if (sec/10==0)
                {
                    duration.setText(min+":0"+sec);
                }
                else
                {
                    sec=Math.round((sec*100.0)/100.0);
                    duration.setText(min+":"+sec);
                }
                //System.out.println(mediaPlayer.getStatus());
                mediaPlayer.setOnEndOfMedia(()->{
                    System.out.println("Song complete");
                    mediaPlayer.stop();
                    if (isDownloaded==true)
                    {
                        try
                        {
                            String key = "SPK CofnCode CnC";
                            File inputFile = new File(getPathForDownloadedSong(allSongs.get(currIdx)));
                            File encryptedFile = new File(getPathForDownloadedSong(allSongs.get(currIdx)));

                            try {
                                CryptoUtils.encrypt(key, inputFile, encryptedFile);
                            } catch (CryptoException ex) {
                                System.out.println(ex.getMessage());
                                ex.printStackTrace();
                            }
                        }
                        catch (CryptoException ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                    if (repeatMode=="Song")
                    {
                        currIdx=currIdx-1;
                        try {
                            goToNextSong();
                        } catch (IOException | CryptoException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    else if (repeatMode=="Playlist")
                    {
                        if (currIdx>=allSongs.size())
                        {
                            currIdx=-1;
                        }
                        try {
                            goToNextSong();
                        } catch (IOException | CryptoException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    if (isShuffleOn==false)
                    {
                        try {
                            goToNextSong();
                        } catch (IOException | CryptoException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        try {
                            setRandomSong();
                        } catch (IOException | CryptoException e) {
                            e.printStackTrace();
                        }
                    }
                });
            });
            try
            {
                sleep(1000);
            }
            catch(InterruptedException e)
            {

            }
        }
        currSong.stop();
    }

    public static void clearDirectory()
    {
        File file = new File(".\\src\\SongInfo");
        String[] myFiles;
        if (file.isDirectory())
        {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++)
            {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void stopCurrSong()
    {
        clearDirectory();
        mediaPlayer.stop();
        songPlaying=false;
        playPause.setGraphic(new ImageView(playButtonImage));
        duration.setText("0:00");
        seekbar.setValue(0);
    }

    public void increaseVolume()
    {
        if (mediaPlayer.getVolume()<1.0)
        {
            mediaPlayer.setVolume(mediaPlayer.getVolume()+0.125);
        }
    }

    /**
     * decrease volume of media
     */
    public void decreaseVolume()
    {
        if (mediaPlayer.getVolume()>0)
        {
            mediaPlayer.setVolume(mediaPlayer.getVolume()-0.125);
        }
    }

    protected static void closePlayer() throws IOException {
        LogOffRequest lor = new LogOffRequest();
        lor.myRequest();
        clearDirectory();
        System.exit(0);
    }

    public void ClearHistory()
    {
        MiddlePageController.history.clear();
        ObservableList<String> observeHistory=FXCollections.observableArrayList(MiddlePageController.history);
        History.setItems(observeHistory);
        History.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    public void incSync()
    {
        sync=sync+1;
        System.out.println(sync);
        diff.setText(String.valueOf(sync));
    }
    public void decSync()
    {
        sync=sync-1;
        System.out.println("dec"+sync);
        diff.setText(String.valueOf(sync));

    }
//    public void displayName(ActionEvent event)
//    {
//        String username = UserData.getUname();
//        System.out.println("hello "+username);
//    }


}
