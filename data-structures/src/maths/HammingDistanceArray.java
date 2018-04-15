package maths;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/

public class HammingDistanceArray
{
    private static Map<Pair<Integer, Integer>, Integer> count1Map = new HashMap<>();
    private static int numberOf1s(Integer integer) {
        int num1 = 0;
        while (integer > 0) {
            num1 =num1 +  integer % 2;
            integer = integer/2;
        }
        return num1;
    }
    private static int hammingDistanceBetweenTwo(Integer a, Integer b) {

        if ( count1Map.containsKey(new Pair<>(a,b))) {
            return count1Map.get(new Pair<>(a,b));
        } else {
            count1Map.put(new Pair<>(a,b), numberOf1s(a ^ b));
            return count1Map.get(new Pair<>(a,b));
        }

    }
    public static int hammingDistance(final List<Integer> A) {

        int total = 0;
        for (int i = 0; i< A.size() ; i++) {
            for (int j=0; j< A.size() ;j++) {
                total = (total + hammingDistanceBetweenTwo(A.get(i) , A.get(j))) % 1000000007;
            }
        }
        return total;
    }

    public static void main(String[] args)
    {
        Map<Pair<Integer, Integer>, Integer> count1Map = new HashMap<>();
        count1Map.put(new Pair<>(2, 3), 1);
        count1Map.put(new Pair<>(2, 3), 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(6);
        System.out.println(hammingDistance(arrayList));
    }
}
