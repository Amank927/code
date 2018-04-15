package dataArtisians;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Station
{
    static class Triplet implements Comparable{
      int tankId;
      int fuel;
      int time;
      public Triplet(int tankId, int f, int t) {
          this.tankId = tankId;
          this.fuel = f;
          this.time = t;
      }

        @Override
        public int compareTo(Object o)
        {
            Triplet that = (Triplet) o;
            if(this.time != that.time) {
                return this.time - that.time;
            }  else {
                return this.tankId - that.tankId;
            }
        }
    }
    public static int solution(int[] A, int X, int Y, int Z) {
        List<Triplet> pq = new ArrayList<>();
        pq.add(new Triplet(1, X,0));
        pq.add(new Triplet(2, Y,0));
        pq.add(new Triplet(3, Z,0));
        int time = 0;

//        for(int i=0; i<pq.size();i++){
//            Triplet currTriplet = pq.get(i);
//            System.out.println(currTriplet.fuel + "  "+currTriplet.time);
//        }
        for(int i=0; i < A.length ;i++) {
            boolean added = false;
            Collections.sort(pq);
            for(int j=0; j< 3;j++) {
                Triplet currTriplet = pq.get(j);
                Integer curr = currTriplet.fuel;
                Integer t =  currTriplet.time;
                if(curr >= A[i]) {
                    pq.remove(currTriplet);
                    time = Math.max(t, time);
                    pq.add(new Triplet(currTriplet.tankId, curr-A[i], t + A[i]));
                    added = true;
                    break;
                }
            }
            if(!added) {
                return -1;
            }
        }
        return time;
    }
    public static void main(String[] args)
    {
        int X, Y, Z;
        int[] a = {2,8,9,3,1,8,4,3,14,1};
        //int[] a = {5};
        int res = solution(a, 28,10,29);
        //res = solution(a, 4, 0, 3);
        System.out.println(res);
    }
}
