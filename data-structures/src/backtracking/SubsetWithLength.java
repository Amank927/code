package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithLength
{
    public static void allSubset(ArrayList<Integer> list, int index, int length,
                          ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> finalRes) {
        if(curr.size() == length) {
            System.out.println(curr);
            if (curr.size() > 0)
            curr.remove(curr.size() -1);
        }

        if (index >= list.size()) {
            return;
        }
        //allSubset(list, index + 1, length, curr, finalRes );
        curr.add(list.get(index));
        allSubset(list, index + 1, length, curr, finalRes);
    }

    public static  void subsetUtil(ArrayList<Integer> list, int length,
                                   ArrayList<ArrayList<Integer>> finalRes) {
        for(int i =0; i < list.size() ; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            allSubset(list, i, length, curr, finalRes);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2 ,3, 4);
        subsetUtil(new ArrayList<>(list), 2, new ArrayList<ArrayList<Integer>>());

    }
}
