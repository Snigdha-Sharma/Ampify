package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Sends request to server for creating a new user group
 */
public class NewUserGroupRequest extends Request
{
    String uname=UserData.getUname();
    String grpName;
    boolean created;
    ArrayList<String> selUsers;

    /**
     * @param grpName Name of the group created
     * @param selectedUsers list of members in the group
     * @throws IOException
     */
    NewUserGroupRequest(String grpName, List<String> selectedUsers) throws IOException
    {
        this.grpName=grpName;
        selUsers=new ArrayList<>();
        for (String x:selectedUsers)
        {
            selUsers.add(x);
        }
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException sends request to server
     */
    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("NewUserGroupRequest");
        dos.writeUTF(grpName);
        dos.writeUTF(uname);
        ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(selUsers);
        created=dis.readBoolean();
        dis.close();
        dos.close();
        oos.close();
    }

    /**
     * @return if the creation of user group was successful or not
     */
    public boolean isSuccessfullyCreation()
    {
        return created;
    }
}
