package ThreadsPractice;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JavaRWLockSharedRes<T> implements SharedResource<T>
{
    private T resource;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public JavaRWLockSharedRes(T init) {
        this.resource = init;
    }

    @Override
    public T read()
    {


        T res = null;
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " Inside Read");
            Thread.sleep(10000);
            res = resource;
            System.out.println(Thread.currentThread().getName() + " finished reading");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return res;
    }

    @Override
    public void write(T newR)
    {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " Inside write");
            this.resource = newR;
            System.out.println(Thread.currentThread().getName() + " finished writing");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }
}
