package sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class LocalSongFiles
{
    File file;
    FileWriter writer;
    FileReader reader;

    public void makeFreshFile()
    {
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

    public void searchLocalSongs()
    {
        Stack<File> path=new Stack<File>();
        File[] init=File.listRoots();
        for (File x:init)
        {
            path.push(x);
            System.out.println(x.getAbsolutePath());
        }
        while(!path.empty())
        {
            File temp=path.peek();
            path.pop();
            System.out.println(temp);
            File[] subFiles=temp.listFiles();
            //System.out.println(subFiles);
            if (subFiles!=null)
            {
                for (File x:subFiles)
                {
                    if (x.getName().endsWith(".mp3"))
                    {
                        try
                        {
                            writer.write(x.getAbsolutePath());
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
        }
        try
        {
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[]args)
    {
        LocalSongFiles l=new LocalSongFiles();
        l.makeFreshFile();
        l.searchLocalSongs();
    }
}
