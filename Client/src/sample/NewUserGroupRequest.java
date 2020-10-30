package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class NewUserGroupRequest extends Request
{
    String uname="";
    String grpName;
    ArrayList<String> selUsers;

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

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("NewUserGroupRequest");
        dos.writeUTF(grpName);
        dos.writeUTF(uname);
        ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(selUsers);
        dis.close();
        dos.close();
        oos.close();
    }
}
