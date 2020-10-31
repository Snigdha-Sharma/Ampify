package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class loader
{
    String[] retArray(String path) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(path));
        ArrayList<String> list2 = new ArrayList<String>();
        String temp = "";
        for (String line : lines)
        {
            if (line.trim().isEmpty())
            {
                list2.add(temp);
                temp = "";
            }
            else
            {
                temp = temp + line + " ";
            }
        }
        int count=0;
        for (String x2 : list2)
        {
            count++;
        }
        String arrstr[] = new String[count];
        int i = 0;
        for (String str : list2)
        {
            arrstr[i] = str;
            i++;
        }
        return arrstr;
    }
}