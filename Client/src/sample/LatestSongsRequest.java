package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

    }

    public List<String> getLatestSongs()
    {
        return ls;
    }
}
