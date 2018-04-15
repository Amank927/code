package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentHashMap
{
    private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public synchronized void addInMap(int key, int value) {
        map.put(key,value);
    }

    public synchronized Integer get(int key) {
        return map.get(key);
    }

    public synchronized Set<Map.Entry<Integer, Integer>> entrySet() {
        return map.entrySet();
    }

    public static void main(String[] args)
    {
        UseConcurrentHashMap hashMap = new UseConcurrentHashMap();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0 ;i<10; i++) {
                    hashMap.addInMap(i, i+10);
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0 ;i<10; i++) {
                    hashMap.addInMap(0, i+10);
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true) {
                    System.out.println(hashMap.get(0));
                    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                        System.out.println("key " + entry.getKey() + "value " + entry.getValue());
                        try {
                            Thread.sleep(100l);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
