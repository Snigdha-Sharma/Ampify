package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LogOffRequest extends Request
{

    LogOffRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("LogOffRequest");
    }
}
