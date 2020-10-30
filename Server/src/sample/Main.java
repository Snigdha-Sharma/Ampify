package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.*;

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
        String uname="",pwd;
        try
        {
            requestType=dis.readUTF();
            switch(requestType)
            {
                case "LoginRequest":
                    uname=dis.readUTF();
                    pwd= dis.readUTF();
                    ServerLoginRequest ob=new ServerLoginRequest(uname,pwd);
                    dos.writeBoolean(ob.isValidUser());
                    if(ob.isValidUser())
                    {
                        //Main.activeUsers.add(uname);
                    }
                break;

                case "RegisterNewUser":
                    uname=dis.readUTF();
                    pwd= dis.readUTF();
                    ServerRegisterNewUser newUser=new ServerRegisterNewUser(uname,pwd);
                    dos.writeBoolean(newUser.isRegisteredSuccessfully());
                    break;

                case "AllSongsRequest":
                    ServerAllSongsRequest asr=new ServerAllSongsRequest();
                    ResultSet rs=asr.getAllSongsSet();
                    OutputStream os=s.getOutputStream();
                    ObjectOutputStream oos=new ObjectOutputStream(os);
                    List<String> back = new ArrayList<>();
                    while(rs.next())
                    {
                        back.add(rs.getString(1));
                    }
                    oos.writeObject(back);
                    break;

                case "UserRequest":
                    String username, name, phn, email, dob, state;
                    String pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, band1, rock1;
                    String eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, marathi1, guj1;
                    String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14;

                    username = dis.readUTF();
                    name=dis.readUTF();
                    phn=dis.readUTF();
                    email=dis.readUTF();
                    dob=dis.readUTF();
                    state=dis.readUTF();

                    pop1=dis.readUTF();
                    rap1=dis.readUTF();
                    classical1=dis.readUTF();
                    metal1=dis.readUTF();
                    contemp1=dis.readUTF();
                    folk1=dis.readUTF();
                    romantic1=dis.readUTF();
                    hiphop1=dis.readUTF();
                    brostep1=dis.readUTF();
                    band1=dis.readUTF();
                    rock1=dis.readUTF();

                    eng1=dis.readUTF();
                    hindi1=dis.readUTF();
                    telugu1=dis.readUTF();
                    harayanvi1=dis.readUTF();
                    bihari1=dis.readUTF();
                    punjabi1=dis.readUTF();
                    french1=dis.readUTF();
                    spanish1=dis.readUTF();
                    marathi1=dis.readUTF();
                    guj1=dis.readUTF();

                    a1=dis.readUTF();
                    a2=dis.readUTF();
                    a3=dis.readUTF();
                    a4=dis.readUTF();
                    a5=dis.readUTF();
                    a6=dis.readUTF();
                    a7=dis.readUTF();
                    a8=dis.readUTF();
                    a9=dis.readUTF();
                    a10=dis.readUTF();
                    a11=dis.readUTF();
                    a12=dis.readUTF();
                    a13=dis.readUTF();
                    a14=dis.readUTF();;

                    ServerUserDataRequest newData=new ServerUserDataRequest(username, name, phn, email, dob, state, pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, band1, rock1, eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, marathi1, guj1, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                    dos.writeBoolean(newData.isFullSuccessful());
                    break;

                case "NewPlaylistRequest":
                    String playlistName=dis.readUTF();
                    System.out.println(playlistName);
                    ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                    ArrayList<String> selectedSongs= (ArrayList<String>) ois.readObject();
                    for (String x:selectedSongs)
                    {
                        System.out.println(x);
                    }
                    break;

                case "LogOff":
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
            s.close();
            this.dis.close();
            this.dos.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
