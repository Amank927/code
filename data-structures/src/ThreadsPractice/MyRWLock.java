package ThreadsPractice;

public class MyRWLock
{
    private int numReaders = 0;

    private int numWriters = 0;

    private int numWaitingWriters = 0;

    public synchronized void readLock()
    {
        try {
            while (numWriters > 0 || numWaitingWriters > 0) {
                this.wait();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        numReaders++;
    }

    public synchronized void readUnlock()
    {
        numReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock()
    {
        numWaitingWriters++;
        try {
            while (numReaders > 0 || numWriters > 0) {
                this.wait();
            }
            numWriters++;
            numWaitingWriters--;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeUnlock()
    {
        numWriters--;
        this.notifyAll();
    }
}
