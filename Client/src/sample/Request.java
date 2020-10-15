package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

abstract public class Request
{
    InetAddress ip;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    Request()
    {
        try
        {
            ip=InetAddress.getByName("127.0.0.1");
            s=new Socket(ip,5056);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public abstract void myRequest() throws IOException;
}
