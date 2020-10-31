package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Sends request to server to register new user
 */
public class RegisterRequest extends Request
{
    private String uname,pwd;
    private boolean registered=false;

    /**
     * @param uname username of user
     * @param pwd password of user
     * @throws IOException
     */
    RegisterRequest(String uname,String pwd) throws IOException
    {
        this.uname=uname;
        this.pwd=pwd;
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException sends request to server
     */
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

    /**
     * @return if the registration was successful or not
     */
    public boolean isSuccessfullyRegistered()
    {
        return registered;
    }

}
