package arrays;

import java.util.ArrayList;

public class MaxAbsoluteDiff
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(3));
        arrayList.add(new Integer(-1));
        System.out.println(maxArr(arrayList));
    }
    public static int maxArr(ArrayList<Integer> A) {
        int max = 0;

        for (int i =0;i<A.size() ; i++) {
            for (int j = i+1 ; j< A.size() ; j++) {
                int current = Math.abs(A.get(j) - A.get(i))  + Math.abs(j -i );
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

}
