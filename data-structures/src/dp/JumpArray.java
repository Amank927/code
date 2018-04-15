package dp;

import java.util.ArrayList;

public class JumpArray
{
    public int jump(ArrayList<Integer> a) {
        int len = a.size();
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i=1; i< len ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i =1; i< len ;i++) {
            for (int j = 0; j < i ;j++) {
                if ( i -j <= a.get(j) && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    //System.out.println(dp[i]);
                }
            }
        }
        if (dp[len -1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[len-1];
        }
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.get(0).set(0,'X');
    }
}
