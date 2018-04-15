package dp;

import java.util.List;

public class LIS
{
    public int lis(final List<Integer> a) {
        int[] dp = new int[a.size()+1];
        for (int i=0; i< a.size();i++) {
            dp[i] = 1;
        }
        for (int i=1;i<a.size();i++) {
            for (int j=0; j<i ;j++) {
                if (a.get(i) > a.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        int ans = 0;
        for (int i =0; i<a.size();i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
