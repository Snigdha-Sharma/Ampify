package sample;

import com.sun.deploy.net.HttpRequest;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

class SrtParser
{
//        String[]input=new String[]{
//        "1 00:00:05,000 --> 00:00:15,000 Created and Encoded by --",
//        "Bokutox -- of",
//        "www.YIFY-TORRENTS.com. The Best 720p/1080p/3d movies with the lowest file size on the internet. World of Warcraft - Outland PVP (EU) - Torporr (name)",
//        "2 00:01:12,246 --> 00:01:17,751 That was when the icecaps had melted because of the greenhouse gases...",
//        "3 00:01:17,960 --> 00:01:20,421 ...and the oceans had drowned cities...",
////        "4", "00:01:20,671","--> 00:01:23,298 ...","alongall the shorelines of the world."
//        };
    TreeMap<Integer,String> lyrics=new TreeMap<Integer, String>();
    //HashMap<Integer, String> lyrics = new HashMap<Integer, String>();
    String path="C:\\Users\\Spardha Sharma\\Desktop\\AmpifyServer\\src\\Songs\\BlindingLights.srt";

    //String path="http://localhost:8080/BlindingLights.srt";
    loader ld=new loader();
    String[] input=ld.retArray(path);
    int x=1;
    Pattern p=Pattern.compile("^([0-9]*) ([0-9]{2}):([0-9]{2}):([0-9]{2}),[0-9]{3} --> ([0-9]{2}):([0-9]{2}):([0-9]{2}),[0-9]{3} (.*)");

    SrtParser() throws IOException
    {

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
            System.out.println(seconds1+" "+seconds2+" "+str);
            lyrics.put(seconds1,str);
//            for(int k=seconds1;k<seconds2;k++)
//            {
//                lyrics.put(k,str);
//            }
//        Line l=new Line(index,str,seconds1,seconds2);
//        lines.add(l);
        }
    }
//        List<Line> res()
//        {
//            return lines;
//        }


};