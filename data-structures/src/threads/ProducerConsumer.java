package threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer
{
    Queue<Integer> queue = new LinkedList<>(); ;
    private int capacity;

    public ProducerConsumer(int capacity)
    {

        this.capacity = capacity;
    }

    public void produce() throws InterruptedException
    {
        int val = 0;
        while (true) {
            synchronized (queue) {
                if (queue.size() == capacity) {
                    try {
                        System.out.println("Now full");
                        queue.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                val++;
                queue.add(val);
                System.out.println(Thread.currentThread().getName() + " Produced "+ val);
                Thread.sleep(1000l);
                queue.notify();
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (queue) {
                if (queue.size() == 0) {
                    try {
                        System.out.println("Now empty");
                        queue.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int res = queue.poll();
                System.out.println(Thread.currentThread().getName() + " Consumed " + res);
                queue.notify();
            }
        }

    }

    public static void main(String[] args)
    {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    producerConsumer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    producerConsumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    producerConsumer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    producerConsumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

