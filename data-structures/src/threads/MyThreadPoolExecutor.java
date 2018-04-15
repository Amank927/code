package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPoolExecutor
{
    private MyBlockingQueue<Runnable> blockingQueue = new MyBlockingQueue<>(10);

    private List<PoolThread> threads = new ArrayList<>();

    private boolean isStopped;

    private int maxThreads = 1;

    public MyThreadPoolExecutor()
    {
        new MyThreadPoolExecutor(maxThreads);
    }

    public MyThreadPoolExecutor(int maxThreads)
    {
        this.isStopped = false;
        this.maxThreads = maxThreads;
        for( int i =0; i< maxThreads ;i++) {
            PoolThread poolThread = new PoolThread(blockingQueue);
            threads.add(poolThread);
            poolThread.start();
        }
    }


    public synchronized void execute(Runnable runnable) {
        if(!isStopped) {
            try {
                blockingQueue.enqueue(runnable);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Thread Pool Executor is stopped");
        }
    }

    public synchronized void shutDown(){
        this.isStopped = true;
        for(int i=0; i< maxThreads ;i++) {
            threads.get(i).stopThisThread();
        }
    }


    public static void main(String[] args)
    {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(3);
        Runnable task1 = new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (i < 10) {
                    System.out.println("Running Task1");
                    try {
                        Thread.sleep(100l);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        };

        Runnable task2 = new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (i < 10) {
                    System.out.println("Running Task2");
                    try {
                        Thread.sleep(100l);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        };
        Runnable task3 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Running Task3");
            }
        };
        myThreadPoolExecutor.execute(task1);
        myThreadPoolExecutor.execute(task2);
        myThreadPoolExecutor.execute(task3);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThreadPoolExecutor.shutDown();
    }
}
