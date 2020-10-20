package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LoginRequest extends Request
{
    boolean found=false;
    private String uname,pwd;

    LoginRequest(String uname,String pwd) throws IOException
    {
        this.uname=uname;
        this.pwd=pwd;
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("LoginRequest");
        dos.writeUTF(uname);
        dos.writeUTF(pwd);
        found=dis.readBoolean();
        dis.close();
        dos.close();
    }

    public boolean isValidUser()
    {
        return found;
    }
}
