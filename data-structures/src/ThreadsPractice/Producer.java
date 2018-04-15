package ThreadsPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Producer<T> implements Runnable
{
    private MyBlockingQueueP<T> queue;

    public Producer(MyBlockingQueueP<T> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        int i=0;
        while (true) {

            try {
                System.out.println("Running Producer and putting "+ i);
                Object obj =  i;
                queue.enque((T) obj);
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
