package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PoolThread extends Thread
{
    private MyBlockingQueue<Runnable> blockingQueue;


    public boolean isStopped = false;

    public PoolThread(MyBlockingQueue<Runnable> blockingQueue )
    {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run()
    {
        while (!isStopped) {

            try {
                Runnable runnable = blockingQueue.dequeue();
                if(runnable != null) {
                    runnable.run();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThisThread() {
        isStopped = true;
        this.interrupt();
    }
}
