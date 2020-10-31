package sample;

import java.io.*;
import java.util.List;

/**
 * To fetch all users from the database
 */
public class AllUsersRequest extends Request
{

    List<String> ls;

    /**
     * @throws IOException Creates new data input and output streams
     */
    AllUsersRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException Sends request to server to fetch all users
     */
    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("AllUsersRequest");
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

    public List<String> allUsersList()
    {
        return ls;
    }
}
