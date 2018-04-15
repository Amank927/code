package arrays;

/* IMPORTANT: Multiple classes and nested static classes are supported */


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class TestClass {

    public static boolean validate(ArrayList<Integer> list , Integer value, Integer start) {
        if (start + value > list.size()) {
            return false;
        } else {
            for (int i=start+1 ;i< start+value ;i++) {
                if (list.get(i) != value) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int group(ArrayList<Integer> list, Integer n) {


        int sum = 0;
        int i =0;
        while (i < list.size()) {
            boolean val = validate(list, list.get(i), i);
            if (!val) {
                return -1;
            }
            i = i + list.get(i);
            sum++;
        }
        return sum;
    }
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=0;i<N; i++) {
            int n = s.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0;j<n ;j++) {
                list.add(s.nextInt());
            }
            int total = group(list, n);
            if (total > 0) {
                System.out.println(total);
            } else {
                System.out.println("Invalid Data");
            }
        }
    }
}
