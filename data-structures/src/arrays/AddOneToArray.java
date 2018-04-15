package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddOneToArray
{
    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int index = 0;
        for (int i =0; i< a.size() - 1 && a.size() > 0 ;){
            if (a.get(i) != 0){
                break ;
            } else {
                a.remove(i);
            }
        }
        ArrayList<Integer> newArray = new ArrayList<>();
        int reminder = 1;
        int newValue  = 0;
        for (int i = a.size() -1 ; i>=0 ; i--) {
            int current = a.get(i);
            if (current == 9 && reminder == 1) {
                reminder = 1;
                newValue = 0;
            }
            else {
                newValue = current + reminder;
                reminder = 0;
            }
            newArray.add(newValue);
        }
        if (reminder == 1) {
            newArray.add(reminder);
        }
            int start = 0;
            int end = newArray.size() - 1;
            while (start < end) {
                int temp = newArray.get(end);
                newArray.set(end, newArray.get(start));
                newArray.set(start, temp);
                start ++;
                end --;
            }
        return newArray;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(nums[0], 0);
        for (int i =1;i < nums.length ; i++) {
            int diff = target - nums[i];
            if (hash.containsKey(diff)) {
                res[0] = hash.get(diff);
                res[1] = i;
                break;
            } else {
                hash.put(nums[i], i);
            }
        }
        return res;
    }
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=1 ;i<=A; i++) {
            if (i%3==0 && i%5==0) {
                res.add("FizzBuzz");
            }
            if(i%3== 0) {
                res.add("Fizz");
            }
            if(i%5 ==0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(0));
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(9));
        arrayList.add(new Integer(9));
        arrayList.add(new Integer(4));
        System.out.println(plusOne(arrayList));
    }


}
