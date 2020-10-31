package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Sends request to server for creating a new playlist
 */
public class NewPlaylistRequest extends Request
{
    String uname=UserData.getUname();
    String nameOfPlaylist;
    ArrayList<String> songs;
    boolean created;

    /**
     * @param nameOfPlaylist Name of the playlist created
     * @param songList List of songs in playlist
     * @throws IOException
     */
    NewPlaylistRequest(String nameOfPlaylist, List<String> songList) throws IOException
    {
        this.uname=uname;
        this.nameOfPlaylist=nameOfPlaylist;
        songs=new ArrayList<>();
        for (String x:songList)
        {
            songs.add(x);
        }
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException Sends request to server
     */
    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("NewPlaylistRequest");
        dos.writeUTF(nameOfPlaylist);
        dos.writeUTF(uname);
        ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(songs);
        created=dis.readBoolean();
        dis.close();
        dos.close();
        oos.close();
    }

    /**
     * @return returns if playlist creation was successful or not
     */
    public boolean isSuccessfullyCreation()
    {
        return created;
    }
}
