package threads;

import java.util.HashMap;

public class MyConcurrentHashMap<K, V>
{
    static class Node<K, V>
    {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, int hash, Node<K, V> next)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int capacity = defaultCapacity;
    private static int defaultCapacity = 4;
    private static double loadFactor = 0.75;
    private static int currentCount = 0;

    private Node<K, V>[] segment;

    public MyConcurrentHashMap() {
        this(defaultCapacity, loadFactor);
    }

    public MyConcurrentHashMap(int capacity, double loadFactor)
    {
        segment = new Node[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.currentCount = 0;
    }
    private  void put(K key, V value) {
        if(currentCount >= capacity*loadFactor) {
            segment = resize();
        }
        int hash = key.hashCode() % capacity;
        if(segment[hash] == null) {
            segment[hash] = new Node<>(key, value, hash, null);
        } else {
            System.out.println("overwriting");
            Node<K, V> head = segment[hash];
            synchronized (head) {
                while (head != null) {
                    if (head.key == key) {
                        head.value = value;
                        return;
                    }
                    head = head.next;
                }
                segment[hash].next = new Node<>(key, value, hash, null);
            }
        }
        currentCount++;
    }

    private Node<K, V>[] resize() {
        Node<K, V>[] oldTab = this.segment;
        this.capacity =  (capacity*2);
        Node<K, V>[] newTab = new Node[capacity];
        for(int i =0; i< oldTab.length ;i++) {
            if(oldTab[i] != null) {
                newTab[i] = oldTab[i];
            }
        }
        return newTab;

    }

    private V get(K key) {
        int hash = key.hashCode() % capacity;
        if(segment[hash] == null) {
            return null;
        } else {
            Node<K, V> head = segment[hash];
            while (head != null) {
                if(head.key == key) {
                    return head.value;
                } else {
                    head = head.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args)
    {

        MyConcurrentHashMap<Integer, Integer> myConcurrentHashMap = new MyConcurrentHashMap<>();
        for(int i=0; i< 14 ;i++) {
            myConcurrentHashMap.put(i, i+11);
            System.out.println(myConcurrentHashMap.get(i));
        }

        Thread w1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (true) {
                    myConcurrentHashMap.put(i, i+10);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 10) {
                        i =0;
                    }
                    i++;

                }
            }
        });

        Thread r1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (true) {
                    System.out.println("key " + i +" value " + myConcurrentHashMap.get(i));
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 10) {
                        i =0;
                    }
                    i++;
                }
            }
        });

        w1.start();
        r1.start();


    }
}

