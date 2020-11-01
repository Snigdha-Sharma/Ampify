package sample;

import java.io.*;
import java.util.List;

public class RecommendationsRequest extends Request
{

    List<String> artist,language,genre,likes,mostPlayed;

    RecommendationsRequest() throws IOException
    {
        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("Recommendations");
        dos.writeUTF(UserData.getUname());
        InputStream is=s.getInputStream();
        ObjectInputStream ois=new ObjectInputStream(is);
        try
        {
            artist= (List<String>) ois.readObject();
            genre= (List<String>) ois.readObject();
            language= (List<String>) ois.readObject();
            likes= (List<String>) ois.readObject();
            mostPlayed=(List<String>)ois.readObject();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        dis.close();
        dos.close();
    }

    public List<String> getRecommendationsByArtist()
    {
        return artist;
    }

    public List<String> getRecommendationsByLanguage()
    {
        return language;
    }

    public List<String> getRecommendationsByGenre()
    {
        return genre;
    }

    public List<String> getRecommendationsByLikes()
    {
        return likes;
    }

    public List<String> getRecommendationsByMostPlayed()
    {
        return mostPlayed;
    }
}
