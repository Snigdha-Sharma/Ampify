package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Creates a login request to be sent to server
 */
public class LoginRequest extends Request
{
    boolean found=false;
    private String uname,pwd;

    /**
     * @param uname username of user
     * @param pwd password of user
     * @throws IOException
     */
    LoginRequest(String uname,String pwd) throws IOException
    {
        this.uname=uname;
        this.pwd=pwd;
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException Sends request to server for logging the user in
     */
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

    /**
     * @return if the user has valid credentials or not
     */
    public boolean isValidUser()
    {
        return found;
    }
}
