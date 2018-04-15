package ThreadsPractice;

public class UnoptimisedSharedRes<T> implements SharedResource<T>
{
    private T resource;

    public UnoptimisedSharedRes(T initialRes) {
        this.resource = initialRes;
    }

    @Override
    public synchronized T read()
    {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resource;
    }

    @Override
    public synchronized void write(T t)
    {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.resource = t;
    }
}
