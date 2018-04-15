package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumSubsets
{
    public static void Subsets(ArrayList<Integer> list, int index , ArrayList<Integer> curr) {
        //System.out.println(curr);
        if (index >= list.size()) {
            System.out.println(curr);
            return;
        }
        curr.add(list.get(index));
        Subsets(list, index + 1, curr);
        if (curr.size() > 0) {
            curr.remove(curr.size() -1);
        }
        Subsets(list, index +1, curr);

    }

    public static void sumSubsetsUtil(ArrayList<Integer> list) {
            Subsets(list, 0, new ArrayList<>());
    }

    public static void subsetSum(ArrayList<Integer> list, int index, int sum) {
        //System.out.println(sum);
        if (index >= list.size()) {
            System.out.println(sum);
            return;
        }
        subsetSum(list, index +1 , sum + list.get(index));
        subsetSum(list, index +1 , sum );
    }
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2 ,3, 4);
        sumSubsetsUtil(new ArrayList<>(list));
        //subsetSum(new ArrayList<>(list), 0, 0);
    }
}
