package arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.TreeMap;


public class Sample
{
    public static void main(String[] args)
    {
        HashMap<String, String> map =  new LinkedHashMap<>();
        map.put("aa", "aa");
        map.put("ab", "ab");

        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;
        System.out.println(arr[1]);
        callFun(arr);
        System.out.println(arr[1]);
    }
    private static void callFun(int[] arr) {
        arr[1] =1 ;
    }
}
