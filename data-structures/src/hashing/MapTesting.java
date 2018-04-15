package hashing;

import dp.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTesting
{
    public static void main(String[] args)
    {
        Map<String, Integer> integerMap = new HashMap<>();

        System.out.println("Testing normal hash map");

        integerMap.put("one", 1);

        integerMap.put("two", 2);

        System.out.println(integerMap.get("one"));

        integerMap.put("one", 3);

        System.out.println(integerMap.get("one"));

        System.out.println("HashMap size : "+ integerMap.size());

        System.out.println("Testing concurrent hash map");
        Map<String, Integer> concurrentIntegerMap = new ConcurrentHashMap<>();

        concurrentIntegerMap.put("one", 1);

        concurrentIntegerMap.put("two", 2);

        System.out.println(concurrentIntegerMap.get("one"));

        concurrentIntegerMap.put("one", 3);

        System.out.println(concurrentIntegerMap.get("one"));

        System.out.println("Concurrent HashMap size : " +concurrentIntegerMap.size());


        HashMap<String , List<Integer>> integerMultiMap = new HashMap<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

        integerMultiMap.put("one", list1);

        integerMultiMap.put("two", Arrays.asList(2, 3));

        System.out.println(integerMultiMap.get("two"));
        System.out.println(integerMultiMap.size());



    }
}
