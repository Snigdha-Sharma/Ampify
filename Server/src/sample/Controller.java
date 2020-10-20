package sample;

import javafx.scene.control.Button;

public class Controller
{
    public Button closeServerButton;
    public Button openServerButton;

    public void setCloseServer()
    {
        Main.closeServer=true;
        System.out.println("Server Closed!");
    }

    public void setOpenServer()
    {
        Main.closeServer=false;
        System.out.println("Server Opened!");
    }

}
