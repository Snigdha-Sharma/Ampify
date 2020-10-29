package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUtil
{
    public static void main(String[] args) throws IOException {
        SrtParser temp=new SrtParser();

        HashMap<Integer,String> t=temp.setup();
        for(int i=0;i<100;i++)
        {
            if(t.get(i)==null)
                t.put(i,"");
            System.out.println(i+" = "+t.get(i));
        }
    }
}
