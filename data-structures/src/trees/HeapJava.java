package trees;

import LinkedList.ListNode;
import jdk.nashorn.internal.ir.SetSplitState;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class HeapJava
{
    static class KV {
        int key;
        int val;
        public KV(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public static void main(String[] args)
    {

        TreeMap<Integer,Integer> integerIntegerTreeMap = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });
        integerIntegerTreeMap.isEmpty();

        Queue<Integer> queue = new LinkedList<>();
        queue.peek();
        integerIntegerTreeMap.put(1, 1);
        integerIntegerTreeMap.put(2, 2);
        integerIntegerTreeMap.put(2, integerIntegerTreeMap.get(2) +1);
//        for (Map.Entry<Integer, Integer> entry : integerIntegerTreeMap.entrySet()) {
//            System.out.println(entry.getKey() + "  "+entry.getValue());
//        }
        while (!integerIntegerTreeMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = integerIntegerTreeMap.firstEntry();
            System.out.println(entry.getKey() + "  "+entry.getValue());
            integerIntegerTreeMap.pollFirstEntry();
        }
        PriorityQueue<KV> priorityQueue = new PriorityQueue<KV>(
                new Comparator<KV>()
                {
                    @Override
                    public int compare(KV o1, KV o2)
                    {
                        return o2.val - o1.val;
                    }
                }
        );

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());

    }
}
