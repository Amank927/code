package searching;

import java.util.ArrayList;

public class FirstGreater
{
    public static int findFirstGreater(ArrayList<Integer> arr, int low, int high, int num) {
        if (high < low ) {
            return -1;
        }
        if(high == low) {
            if(arr.get(low) == num) {
                return low;
            }else {
                return -1;
            }
        }
        if(arr.get(high) < num) {
            return -1;
        }
        int mid = (low + high)/2;
        if(mid - 1 >= low && arr.get(mid) >= num && arr.get(mid -1) < num ) {
            return mid;
        } else if(mid - 1 >= low && arr.get(mid) >= num && arr.get(mid -1) == arr.get(mid -1)) {
            return findFirstGreater(arr, low, mid - 1, num);
        } else {
            return findFirstGreater(arr, mid +1, high, num);
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(10);
        integers.add(15);
        integers.add(15);
        integers.add(16);
        integers.add(16);
        integers.add(18);
        System.out.println(findFirstGreater(integers, 0, integers.size() -1, 16));
    }
}
