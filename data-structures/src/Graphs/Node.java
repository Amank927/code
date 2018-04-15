package Graphs;

public class Node<T>
{
    private T key;

    public Node(T key)
    {
        this.key = key;
    }

    public T getKey()
    {
        return key;
    }

    @Override
    public String toString()
    {
        return key.toString();
    }
}
