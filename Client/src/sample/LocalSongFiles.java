package sample;

import javafx.concurrent.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

public class LocalSongFiles extends Task<ArrayList<Integer>>
{
    File file;
    FileWriter writer;

    public void makeFreshFile()
    {
        System.out.println("Creating a fresh file");
        try
        {
            Files.deleteIfExists(Paths.get("./LocalSongs.txt"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        file=new File("./LocalSongs.txt");
        try
        {
            writer=new FileWriter(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    public void searchLocalSongs()
//    {
//
//    }

    @Override
    protected ArrayList<Integer> call() throws Exception
    {
        makeFreshFile();
        System.out.println("File made");
        int countSongs=0,countVideos=0;
        Stack<File> path=new Stack<File>();
        File[] init=File.listRoots();
        for (File x:init)
        {
            path.push(x);
        }
        while(!path.empty())
        {
            File temp=path.peek();
            path.pop();
            File[] subFiles=temp.listFiles();
            if (subFiles!=null)
            {
                for (File x : subFiles)
                {
                    if (x.getName().endsWith(".mp3") || (x.getName().endsWith(".mp4")))
                    {
                        try
                        {
                            if (x.getName().endsWith(".mp3"))
                            {
                                countSongs++;
                            }
                            else
                            {
                                countVideos++;
                            }
                            writer.write(x.getAbsolutePath());
                            System.out.println(x.getAbsolutePath());
                            writer.write("\n");
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    else if (x.isDirectory())
                    {
                        path.push(x);
                    }

                }
            }
            updateTitle(String.valueOf(countSongs+countVideos));
        }
        try
        {
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        ArrayList<java.lang.Integer> ar=new ArrayList<>();
        ar.add(countSongs);
        ar.add(countVideos);
        return ar;
    }

//    public static void main(String[]args)
//    {
//        LocalSongFiles l=new LocalSongFiles();
//        l.makeFreshFile();
//        l.searchLocalSongs();
//    }
}
