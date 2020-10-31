package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Abstract (parent) class of all kinds of requests
 */
abstract public class Request
{
    InetAddress ip;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    /**
     * Creates socket to send requests to server
     */
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

    /**
     * @throws IOException overridden in subclasses
     */
    public abstract void myRequest() throws IOException;
}
