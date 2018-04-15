package threads;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T>
{
    private int maxSize ;
    private Queue<T> queue;

    public MyBlockingQueue(int maxSize)
    {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void enqueue(T obj) throws InterruptedException
    {
        synchronized (this) {
            while (queue.size() == maxSize) {
                wait();
            }
            queue.add(obj);
            notifyAll();
        }
    }

    public T dequeue() throws InterruptedException
    {
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            T ele = queue.remove();
            notifyAll();
            return ele;
        }
    }
}
