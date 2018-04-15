package sorting;

import java.util.ArrayList;
import java.util.List;

public class PairSort
{
    static class Pair {
        public int key;
        public int value;
        public Pair(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public static List<Pair> sort(List<Pair> list) {
        for(int i = 0; i< list.size() ; i++) {
            for(int j =0 ;j < list.size() - i -1;j++) {
                int k = j + 1;
                if(list.get(j).value > list.get(k).value) {
                    Pair temp = list.get(j);
                    list.set(j, list.get(k));
                    list.set(k, temp);
                }
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 3));
        pairs.add(new Pair(2, 2));
        pairs.add(new Pair(3, 5));
        pairs.add(new Pair(4, 1));
        List<Pair> sorted = sort(pairs);
        for(int i =0 ;i<  sorted.size();i++) {
            System.out.println(sorted.get(i).key + " " + sorted.get(i).value);
        }
    }
}
