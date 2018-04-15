package rippling;

import java.util.HashSet;
import java.util.Set;

public class Power
{
    private static boolean isPowerOf(String str) {
        Set<String> strings = new HashSet<>();
        strings.add("11001");
        strings.add("101");
        strings.add("1");
        if (strings.contains(str)) {
            return true;
        } else {
            return false;
        }
    }



    public static int minPartitions(String string, int start, int end, int[][] dp)  {

        if (start > end) {
            return Integer.MAX_VALUE;
        }

        if (isPowerOf(string.substring(start, end +1))) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i=start;i<end ;i ++) {

            int minPartitionLeft = minPartitions(string, start, i, dp);
            int minPartionRight = minPartitions(string, i+1, end, dp);;
            int currentMIn = Integer.MAX_VALUE;
            if (minPartitionLeft!= Integer.MAX_VALUE && minPartionRight != Integer.MAX_VALUE) {
                currentMIn = minPartitionLeft + minPartionRight + 1;
            }
            res = Math.min(res,  currentMIn);

        }
        return dp[start][end] = res;
    }
    public static void main(String[] args)
    {
        //String string = "110011011";
        String string = "101101101";
        int[][] dp = new int[string.length()+1][string.length() +1];
        int len = string.length();
        for (int i=0 ; i<= len ;i++) {
            for (int j=0 ;j<=len ;j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minPartitions(string, 0, string.length() -1, dp));
    }
}
