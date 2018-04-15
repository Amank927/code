package ThreadsPractice;

public interface SharedResource<T>
{
    public T read();

    public void write(T t);
}
