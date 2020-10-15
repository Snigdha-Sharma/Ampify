package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main extends Application
{

    static HashSet<String> activeUsers;
    protected static boolean closeServer=false;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e->{closeServer=true;
        System.out.println("Server Closed!");});
    }



    public static void main(String[] args) throws IOException
    {
        //launch(args);
        ServerSocket ss= new ServerSocket(5056);
        while(closeServer==false)
        {
            Socket s = null;
            try
            {
                s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                Thread t = new ClientHandler(s, dis, dos);
                t.start();
            }
            catch (Exception e)
            {
                if (s != null)
                {
                    s.close();
                }
                e.printStackTrace();
            }
            //closeServer=(new Scanner(System.in)).nextBoolean();
            //System.out.println(closeServer);
        }
    }
}

class ClientHandler extends Thread
{
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s=s;
        this.dis=dis;
        this.dos=dos;
    }

    @Override
    public void run()
    {
        String requestType;
        try
        {
            requestType=dis.readUTF();
            switch(requestType)
            {
                case "LoginRequest": String uname,pwd;
                uname=dis.readUTF();
                pwd= dis.readUTF();
                ServerLoginRequest ob=new ServerLoginRequest(uname,pwd);
                dos.writeBoolean(ob.isValidUser());
                if(ob.isValidUser()==true)
                {
                    Main.activeUsers.add(uname);
                }
                s.close();
                break;
                case "RegisterNewUser": uname=dis.readUTF();
                pwd= dis.readUTF();
                ServerRegisterNewUser newUser=new ServerRegisterNewUser(uname,pwd);
                dos.writeBoolean(newUser.isRegisteredSuccessfully());
                s.close();
                break;
                case "LogOff": s.close();
                break;
                default: dos.writeBoolean(false);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
