package threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultiReaderWriterSharedResource
{
    private int count = 0;

    MyReadWriteLock readWriteLock = new MyReadWriteLock();
    ReadWriteLock javaRWlock = new ReentrantReadWriteLock();

    public void increaseCount() {
        //readWriteLock.writeLock();
        javaRWlock.writeLock().lock();
        count++;
        //System.out.println("Count increased by " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + "Inside write");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //readWriteLock.writeUnlock();
        javaRWlock.writeLock().unlock();
        System.out.println(Thread.currentThread().getName() + "Exited write");
        System.out.println("-------------");
    }

    public int getCount() {
        //readWriteLock.readLock();
        javaRWlock.readLock().lock();
        int val = count;
        //System.out.println("Count value is " + val + " Read by " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + "Inside read");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {

           e.printStackTrace();
        }
        //readWriteLock.readUnlock();
        javaRWlock.readLock().unlock();
        System.out.println(Thread.currentThread().getName() + "Exited read");
        System.out.println("-------------");
        return val;
    }

}
