package arrays;

import java.util.Arrays;
import java.util.List;

public class SearchRotatedArray
{
    public static int search(final List<Integer> a, int b) {
        return binarySearch(a, 0, a.size() -1 , b);
    }

    private static int binarySearch(final List<Integer> list, int low , int high, int key) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high)/2;
        if (list.get(mid) == key) {
            return mid;
        }
        if (list.get(low) < list.get(mid)) {
            if (list.get(low) <= key && key < list.get(mid)) {
                return binarySearch(list, low, mid -1 , key);
            } else {
                return binarySearch(list, mid + 1, high, key);
            }
        }
        if (list.get(mid) < key && list.get(high) >= key) {
            return binarySearch(list, mid + 1, high, key);
        }
        return binarySearch(list, low, mid-1, key);
    }

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList( 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 );
        System.out.println(search(list, 202));
    }
}
