package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceExample
{
    static class Task1 implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Executing Task1");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task2 implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Executing Task2");
        }
    }
    static class Task3 implements Callable<Integer>
    {
        @Override
        public Integer call() throws Exception
        {
            System.out.println("Executing Task3");
            return 10;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
//        ExecutorService executorService =  Executors.newFixedThreadPool(5);
//        Future<Integer> future = executorService.submit(new Task3());
//        try {
//            Integer res = future.get(10, TimeUnit.MILLISECONDS);
//            System.out.println(res);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        executorService.submit(new Task2());
//
//        System.out.println("Hello2");
//        executorService.shutdown();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        scheduledExecutorService.schedule(new Task3(), 1000, TimeUnit.MILLISECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(new Task2(), 0, 100, TimeUnit.MILLISECONDS);
//        scheduledExecutorService.shutdown();
    }
}
