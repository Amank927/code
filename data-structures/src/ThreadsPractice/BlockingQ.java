package ThreadsPractice;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQ
{
    //BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(5);

    public static void testPCwithMyBlocQue() {
        MyBlockingQueueP<String> sharedQ = new MyBlockingQueueP<>(5);
        Producer<String> pr1 = new Producer(sharedQ);
        Consumer<String> cr1 = new Consumer(sharedQ);
        new Thread(pr1).start();
        new Thread(cr1).start();
    }
    public static void main(String[] args)
    {
        testPCwithMyBlocQue();
//        Queue<Integer> queue = new LinkedList<>();
//
//        BlockingQueue<Integer> sharedQ = new ArrayBlockingQueue<Integer>(5);
//        Producer pr1 = new Producer(sharedQ);
//        Consumer cr1 = new Consumer(sharedQ);
//        new Thread(pr1).start();
//        new Thread(cr1).start();
    }
}
