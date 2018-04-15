package ThreadsPractice;

public class MyRWLockSharedResource<T> implements SharedResource<T>
{
    private T resource;

    private MyRWLock rwLock = new MyRWLock();

    public MyRWLockSharedResource(T resource)
    {
        this.resource = resource;
    }


    @Override
    public T read()
    {
        T ret;
        rwLock.readLock();
        System.out.println(Thread.currentThread().getName() + " inside read");
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ret = resource;
        System.out.println(Thread.currentThread().getName() + " finished reading");
        rwLock.readUnlock();
        return ret;
    }

    @Override
    public void write(T t)
    {
        rwLock.writeLock();
        System.out.println(Thread.currentThread().getName() + " inside write");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        resource = t;
        System.out.println(Thread.currentThread().getName() + " finished writing");
        rwLock.writeUnlock();
    }
}
