package threads;

public class MyLock
{
    private Thread lockingThread;
    private boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked =false;
        this.notifyAll();
    }
}
