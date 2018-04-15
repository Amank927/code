package ThreadsPractice;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueP<T>
{
    private Queue<T> queue ;
    private  int maxSize;

    public MyBlockingQueueP(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void  enque(T ele) throws InterruptedException
    {
        while (queue.size() == maxSize) {
            System.out.println("queue is full");
            this.wait();
        }
        queue.add(ele);
        this.notifyAll();
    }

    public synchronized T deque() {
        T ret = null;
        try {
            while (queue.size() == 0) {
                System.out.println("queue is empty");
                this.wait();
            }
            ret = queue.poll();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
