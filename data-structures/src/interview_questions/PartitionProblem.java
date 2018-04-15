package interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Check if an array can be divided into two equal parts
 */
public class PartitionProblem
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Integer tc = 0;
        if ( scanner.hasNext()){
            tc = scanner.nextInt();
        }
        while (tc-- > 0) {
            Integer n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            Integer sum = 0;
            for (int i =0; i < n ; i++) {
                arr.add(scanner.nextInt());
                sum = sum + arr.get(i);
            }
            if ( (sum )%2 != 0) {
                System.out.println("NO");
            } else if (canBePartitionedToHalf(arr, sum/2 , 0) ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean canBePartitionedToHalf(List<Integer> list, Integer sum, Integer startIndex)
    {
        if (sum == 0) {
            return true;
        }
        for ( int i=startIndex ; i < list.size() ; i++) {
            return canBePartitionedToHalf(list, sum, i+1) || canBePartitionedToHalf(list, sum - list.get(i), i+1);
        }
        return false;
    }
}
