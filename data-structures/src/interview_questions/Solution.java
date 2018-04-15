package interview_questions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int poisonousPlants(int[] p) {

        int[] res = new  int[p.length];
        int currentMin = p[0];
        res[0] = 0;
        int currentMax = p[0];

        for (int i =1; i<p.length ; i++)
        {
            if (p[i] > currentMax ) {
                res[i] = 1;
            }

            if (p[i] < currentMax && p[i] > currentMin) {
                res[i] = res[i-1] + 1;
            }

            if (p[i] < currentMin) {
                currentMin = p[i];
                res[i] = 0;
                currentMax = p[i];
            }

            if (p[i] > currentMax) {
                currentMax = p[i];
            }

        }

        int returnRes = 0;

        for (int i = 0; i< p.length ; i++ )
        {
            if (returnRes < res[i])
            {
                returnRes = res[i];
            }
        }
        return returnRes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int result = poisonousPlants(p);
        System.out.println(result);
        in.close();
    }
}

