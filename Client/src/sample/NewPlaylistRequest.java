package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewPlaylistRequest extends Request
{
    String uname=UserData.getUname();
    String nameOfPlaylist;
    ArrayList<String> songs;
    boolean created;

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
    public boolean isSuccessfullyCreation()
    {
        return created;
    }
}
