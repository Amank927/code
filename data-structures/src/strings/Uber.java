package strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Uber
{
    static class Cab {
        int count;
        int time;
        int currTime;

        public Cab(int count, int time, int currTime)
        {
            this.count = count;
            this.time = time;
            this.currTime = currTime;
        }
    }

    public static void main(String[] args)
    {
        //int[] cab = {1, 2, 3, 1,  2, 1};
        int[] cab = {1, 2};
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Cab> pq = new PriorityQueue<>(
                new Comparator<Cab>()
                {
                    @Override
                    public int compare(Cab o1, Cab o2)
                    {
                        return o1.time - o2.time;
                    }
                }
        );
        for(int i=0; i< cab.length ;i++) {
            if(map.containsKey(cab[i])) {
                map.put(cab[i], map.get(cab[i]) + 1);
            } else {
                map.put(cab[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Cab(entry.getValue(), entry.getKey(), 1));
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int N = 3;
        int i=0;
        int trips = 0;
        while (true) {
            while (!pq.isEmpty()) {
                Cab curr = pq.poll();
                if(curr.currTime == i) {
                    trips = trips + curr.count;
                    pq.add(new Cab(curr.count, curr.time, curr.currTime + curr.time ));
                    if(trips >= N) {
                        System.out.println(i);
                        return;
                    }
                } else if (curr.currTime > i) {
                    pq.add(curr);
                    break;
                } else {
                    pq.add(curr);
                }

            }
            i++;
        }
    }
}
