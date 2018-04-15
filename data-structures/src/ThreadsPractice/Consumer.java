package ThreadsPractice;

import java.util.concurrent.BlockingQueue;

public class Consumer<T> implements Runnable
{
    private MyBlockingQueueP<T> queue;

    public Consumer(MyBlockingQueueP<T> queue) {
        this.queue = queue;
    }
    @Override
    public void run()
    {
        while (true) {
            try {
                System.out.println("Running Consumer " + queue.deque());
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
