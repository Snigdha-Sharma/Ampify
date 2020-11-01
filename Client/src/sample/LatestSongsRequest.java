package sample;

import java.io.*;
import java.util.List;

public class LatestSongsRequest extends Request
{
    List<String> ls;

    LatestSongsRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("RecentlyAdded");
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

    public List<String> getLatestSongs()
    {
        return ls;
    }
}
