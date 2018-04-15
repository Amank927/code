package searching;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch
{
    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int i = 0;
        int j = 0;
        while (i< a.size()) {
            j = 0;
            while (j < a.get(i).size()) {
                if (a.get(i).get(j) == b) {
                    return 1;
                }
                if (b < a.get(i).get(j)) {
                    return 0;
                }
                if ((i+1) < a.size() && b >= a.get(i+1).get(0)) {
                    i++;
                    continue;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(11);
        list2.add(16);
        list2.add(20);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(23);
        list3.add(30);
        list3.add(34);
        list3.add(50);
        arrayList.add(list1);
        arrayList.add(list2);
        arrayList.add(list3);
        System.out.println(searchMatrix(arrayList,17));
    }
}
