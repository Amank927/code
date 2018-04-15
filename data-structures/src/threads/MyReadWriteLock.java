package threads;

public class MyReadWriteLock
{
    private Thread lockingThread;
    private boolean isLocked = false;

    private int readers = 0;

    private int writers = 0;

    private int waitingWriters = 0;

    public synchronized void readLock() {
        while (waitingWriters > 0 || writers > 0) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    public synchronized void readUnlock() {
        readers--;
        notifyAll();
    }

    public synchronized void writeLock() {
        waitingWriters ++;
        while (readers > 0 || writers > 0) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writers++ ;
        waitingWriters-- ;
    }

    public synchronized void writeUnlock() {
        writers--;
        notifyAll();

    }
}
