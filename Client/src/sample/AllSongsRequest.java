package sample;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;
import java.util.Observable;

public class AllSongsRequest extends Request
{
    List<String> ls;

    AllSongsRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

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

    public List<String> allSongsList()
    {
        return ls;
    }
}
