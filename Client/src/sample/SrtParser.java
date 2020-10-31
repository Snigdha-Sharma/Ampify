package sample;

import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SrtParser
{
    TreeMap<Integer,String> lyrics=new TreeMap<Integer, String>();
    String path;
    String[] input;
    int x=1;
    Pattern p=Pattern.compile("^([0-9]*) ([0-9]{2}):([0-9]{2}):([0-9]{2}),[0-9]{3} --> ([0-9]{2}):([0-9]{2}):([0-9]{2}),[0-9]{3} (.*)");

    SrtParser(String path) throws IOException
    {
        this.path=path;
        loader ld=new loader();
        input=ld.retArray(path);
    }

    TreeMap<Integer, String> setup()
    {
        for(int i=0;i<input.length;i++)
        {
            parseLine(i);
        }
        return lyrics;
    }


    void parseLine(int i)
    {
        int count=1;
        String s= input[i];
        Matcher m=p.matcher(s);
        if(m.matches())
        {
            int index=Integer.parseInt(m.group(1));
            int h1=Integer.parseInt(m.group(2));
            int m1=Integer.parseInt(m.group(3));
            int s1=Integer.parseInt(m.group(4));
            int seconds1=h1*3600+m1*60+s1;
            int h2=Integer.parseInt(m.group(5));
            int m2=Integer.parseInt(m.group(6));
            int s2=Integer.parseInt(m.group(7));
            int seconds2=h2*3600+m2*60+s2;
            String str=m.group(8);
            lyrics.put(seconds1,str);
        }
    }
};