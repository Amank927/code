package dp;

/**
 * https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
 */
public class NumWithSum
{
    public static int solve(int A, int B) {

        int[][] dp= new int[A+1][B+1];
        dp[1][0] = 1;
        for (int sum=1 ; sum<=9 && sum<=B  ; sum++) {
            dp[1][sum] = 1;
        }

        for (int digit =2; digit<=A ; digit++) {
            for (int sum=1; sum<=B; sum++) {
                for (int i=1; i<=9;i++) {
                    if (sum -i >=0 ) {
                        dp[digit][sum] = (dp[digit][sum] + dp[digit-1][sum-i])%1000000007;
                    }
                }
            }
        }
        for(int i=0;i<=A;i++) {
            for (int j=0;j<=B;j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        return dp[A][B];
    }

    public static void main(String[] args)
    {
        System.out.println(solve(3,4));
    }
}
