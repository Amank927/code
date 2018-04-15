package bitwise;

import java.util.ArrayList;
import java.util.TreeSet;

public class Operators
{
    public static void main(String[] args)
    {
//        int i =1;
//
//        System.out.println(4 & (i << 2));

        String str = ":1:2";
        String[] arrayList = str.split(":");
        System.out.println(arrayList);
        ArrayList<Integer> list = new ArrayList<>();
        for(int j =1; j< arrayList.length ;j++) {
            list.add(Integer.valueOf(arrayList[j]));
        }
        System.out.println(list);
    }
}
