package threads;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class MyHashMap<K, V>
{
    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

    }

    private static int initialCapacity = 16;

    private static int defaultCapacity = 16;

    private static int currentNumOfNodes = 0;

    private int currentCapacity;
    Node<K, V>[] segment;

    public MyHashMap()
    {
        this(defaultCapacity);
    }

    public MyHashMap(int initialCapacity)
    {
        this.initialCapacity = initialCapacity;
        segment = new Node[initialCapacity];
        this.currentCapacity = initialCapacity;
    }

    public void put(K key, V value)
    {

        int hash = key.hashCode();
        int index = hash % currentCapacity;
        System.out.println(index);
        Node<K, V> node = new Node<>(key, value);

        if(segment[index] != null) {
            System.out.println("Over writing");
            segment[index] = node;
        } else {
            segment[index] = node;
        }
        currentNumOfNodes++;
    }

    public V get(K key) {
        int hash = key.hashCode() % currentCapacity;
        if(segment[hash] == null) {
            return null;
        } else {
            return segment[hash].value;
        }
    }

    public static void main(String[] args)
    {

        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("a", "Mukund");
        myHashMap.put("b", "anurag");
        myHashMap.put("a", "Azhar");
        System.out.println(myHashMap.get("a"));
        System.out.println(myHashMap.get("b"));
        System.out.println(myHashMap.get("wvkjbgc"));

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Mukund");
        map.put(2, "Anurag");
        map.put(1, "Azhar");
        System.out.println(map.get(1));


    }
}
