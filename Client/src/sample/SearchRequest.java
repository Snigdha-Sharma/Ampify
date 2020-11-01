package sample;

import java.io.*;
import java.util.List;

public class SearchRequest extends Request
{
    String input;
    List<String> ls;

    SearchRequest(String input) throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
        this.input=input;
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("SearchSongs");
        dos.writeUTF(input);
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

    public List<String> searchResult()
    {
        return ls;
    }

}
