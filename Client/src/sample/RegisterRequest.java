package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RegisterRequest extends Request
{
    private final String uname,pwd;
    private boolean registered=false;

    RegisterRequest(String uname,String pwd) throws IOException
    {
        this.uname=uname;
        this.pwd=pwd;
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("RegisterNewUser");
        dos.writeUTF(uname);
        dos.writeUTF(pwd);
        registered= dis.readBoolean();
        dis.close();
        dos.close();
    }

    public boolean isSuccessfullyRegistered()
    {
        return registered;
    }

}
