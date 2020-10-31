package sample;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;
import java.util.Observable;

/**
 * Creates request to fetch all songs
 */
public class AllSongsRequest extends Request
{
    List<String> ls;

    /**
     * @throws IOException Creates new data input and output streams
     */
    AllSongsRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException Sends request to server to fetch all songs
     */
    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("AllSongsRequest");
        InputStream is=s.getInputStream();
        ObjectInputStream ois=new ObjectInputStream(is);
        try
        {
            ls= (List<String>) ois.readObject();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        dis.close();
        dos.close();
    }

    /**
     * @return if songs were fetched successfully
     */
    public List<String> allSongsList()
    {
        return ls;
    }
}
