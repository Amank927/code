package hashing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 *
 */
public class PointsStraightLine
{
    public static class Pair
    {
        int a;
        int b;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (a != pair.a) {
                return false;
            }
            return b == pair.b;
        }

        @Override
        public int hashCode()
        {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
    public static int gcd(int a, int b) {
        if(a%b == 0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }
    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() <=1) {
            return a.size();
        }
        int maxPts = 1;
        int maxSamePoints = 1;
        int maxOnVertical = 1;
        int maxOnHorizontal = 1;
        for(int i=0;i<a.size();i++) {
            Map<Pair, Integer> map = new HashMap<>();
            int maxS = 1;
            int maxH = 1;
            int maxV = 1;
            for(int j=i+1; j<a.size() ; j++) {
                Pair pair = new Pair();
                int y = (b.get(j) - b.get(i));
                int x = (a.get(j) - a.get(i));
                if (x == 0 && y==0) {
                    maxS++;
                    continue;
                }
                if (x==0) {
                    maxV++;
                    continue;
                }
                if (y==0) {
                    maxH++;
                    continue;
                }

                int gcd = gcd(x,y);
                pair.a = x/gcd;
                pair.b = y/gcd;
                if (pair.a<0 && pair.b<0) {
                    pair.a = -1*pair.a;
                    pair.b = -1*pair.b;
                }

                if (pair.b >0 && pair.a <0) {
                    pair.b = -1*pair.b;
                }

                if(map.containsKey(pair)) {
                    map.put(pair, map.get(pair) +1);
                }else {
                    map.put(pair, 2);
                }
            }

            maxSamePoints = Math.max(maxSamePoints, maxS);
            maxOnHorizontal = Math.max(maxOnHorizontal, maxH);
            maxOnVertical = Math.max(maxOnVertical, maxV);
            for (Map.Entry<Pair,Integer> entry : map.entrySet()) {
                if (maxPts < entry.getValue()) {
                    maxPts = entry.getValue();
                }
            }
        }
        if (maxSamePoints < a.size()) {
            maxSamePoints = maxSamePoints +1;
        }
        return Math.max(Math.max(maxPts , maxOnHorizontal) , Math.max(maxOnVertical, maxSamePoints));
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.addAll(Arrays.asList(1,1,1));
        b.addAll(Arrays.asList(4,0,-1));
        System.out.println(maxPoints(a,b));
    }
}
