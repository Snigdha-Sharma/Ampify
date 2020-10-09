package sample;

class SampleThread extends Thread
{
    ABC ob;

    SampleThread(ABC ob)
    {
        ob=this.ob;
    }

    public void run()
    {
        ob.a=ob.a+1;
    }
}

public class Example
{
    public static void main(String[] args)
    {
        ABC ob=new ABC();
        ob.a=1;
        ob.b=2;
        ob.c=3;
        SampleThread t=new SampleThread(ob);
        t.run();
    }
}
