package arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContigous
{
    public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(0));
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(9));
        arrayList.add(new Integer(9));
        arrayList.add(new Integer(4));
        System.out.println(maxSubArray(arrayList));
    }
    public static int maxSubArray(final List<Integer> a) {
        int maxSum = a.get(0);
        int tillNoWSum  = a.get(0);

        for (int i =1 ; i < a.size() ; i++) {
            if (tillNoWSum + a.get(i) > a.get(i)) {
                tillNoWSum = tillNoWSum + a.get(i);
            } else {
                tillNoWSum = a.get(i);
            }
            if (tillNoWSum > maxSum) {
                maxSum = tillNoWSum;
            }
        }
        return maxSum;
    }
}
