package maths;

import java.util.HashMap;
import java.util.Map;

public class PowerOfK
{
    public static boolean isPower(int a) {
//        Map<Integer,Integer> powerMap = new HashMap<>();
        if (a == 1) {
            return true;
        }
        int num = a;
        int i =2 ;
        while (i <= Math.sqrt(a) ) {
            int j =2;
             while (Math.pow(i,j ) <= a) {
                 if (Math.pow(i,j ) == a) {
                     return true;
                 }
                 j++;
             }
            i++;
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(Math.pow(1024, 1.0/10));
        System.out.println(isPower(823543));
    }
}
