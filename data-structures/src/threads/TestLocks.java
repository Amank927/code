package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLocks
{
    public static void main(String[] args)
    {
        SharedClass sharedClass = new SharedClass();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                sharedClass.increaseCount();
            }
        },"Writer 1" );
        t1.start();

        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(sharedClass.getCount());
            }
        }, "Reader 1");
        t3.start();

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                sharedClass.increaseCount();
            }
        }, "Writer 2");
        t2.start();


        Thread t4 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(sharedClass.getCount());
            }
        }, "Reader 2");
        t4.start();
    }
}
