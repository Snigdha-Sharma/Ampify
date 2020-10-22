package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LocalSongsService extends Service<java.lang.Integer>
{

    @Override
    protected Task createTask()
    {
        System.out.println("New task created");
        return new LocalSongFiles();
    }
}
