package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDuplicate
{
    public static int repeatedNumber(final List<Integer> a) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i =0; i< a.size() ;i++)
        {
            if (integerSet.contains(a.get(i))) {
                return a.get(i);
            }else {
                integerSet.add(a.get(i));
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        List<Integer> ar =Arrays.asList(3,4,1,4,1);
        System.out.println(repeatedNumber(ar));
    }
}
