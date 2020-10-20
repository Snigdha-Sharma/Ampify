package sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    }
}
