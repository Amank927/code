package rippling;

import java.util.Arrays;
import java.util.List;

public class Uber
{

    public static void main(String[] args)
    {
        List<Integer> songs = Arrays.asList(3, 5);
        int maxTime = 9;
        int len = songs.size();
        int dp[][] = new int[len+1][maxTime+1];

        for (int i=0; i<= len ;i++) {
            for (int j=0 ; j<=maxTime ;j++) {
                dp[i][j] =-1;
            }
        }
        for(int i=1; i< maxTime+1 ; i++) {
            dp[0][i] = -1;
        }

        for (int i=0; i< len +1; i++) {
            dp[i][0] = 0;
        }
        for(int i=1; i<= len ;i++) {
            for(int j=1; j<= maxTime ;j++) {

                if (songs.get(i-1) <= j ) {
                    {

                        if (dp[i - 1][j - songs.get(i - 1)] >= 0 || dp[i - 1][j] >=0 ) {

                            dp[i][j] = Math.max(1 + dp[i - 1][j - songs.get(i - 1)], dp[i - 1][j]);
                        }
                    }
                } else if (dp[i-1][j] >= 0){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        System.out.println(dp[len][maxTime]);
    }
}
