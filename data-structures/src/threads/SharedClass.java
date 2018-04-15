package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedClass
{
    MyLock lock = new MyLock();
    Lock javaLock  = new ReentrantLock();

    private int count;

    public  void increaseCount()
    {
        lock.lock();
        count++;
        try {
            System.out.println("Executing Thread " + Thread.currentThread().getName());
            Thread.sleep(1000l);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public int getCount() {
        lock.lock();
        System.out.println("Executing Thread " + Thread.currentThread().getName());
        int val = this.count;
        lock.unlock();
        return val;
    }
}
