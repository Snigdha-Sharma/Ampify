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
import java.util.TreeMap;

public class FileUtil
{
    public static void main(String[] args) throws IOException
    {
        SrtParser temp=new SrtParser();
        TreeMap<Integer,String> t=temp.setup();
        System.out.println(t);
        System.out.println("TreeSize:"+t.size());
//        for(int i=0;i<t.size();i++)
//        {
//            System.out.println(t.)
////            if(t.get(i)==null)
////                t.put(i,"");
////            System.out.println(i+" = "+t.get(i));
//        }
    }
}
