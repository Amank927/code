package interview_questions;

import java.math.BigInteger;
import java.util.Scanner;

public class BytelandianCoin
{
    public static int total = 100000001;
    public static BigInteger[] result = new BigInteger[total];
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = null;
        for ( int i=0 ; i < total ; i++) {
            result[i] = BigInteger.ZERO;
        }
        while (scanner.hasNext()) {
             n = scanner.nextBigInteger();
            System.out.println(getMaxValue(n));
        }
        scanner.close();

    }

    private static BigInteger getMaxValue(BigInteger n)
    {
        if (n.intValue() == 1 || n.intValue() == 0) {
            return n;
        }
        if ( n.intValue() < total && result[n.intValue()].compareTo(BigInteger.ZERO) != 0 )  {
            return result[n.intValue()];
        }
        BigInteger res1 = getMaxValue(n.divide(new BigInteger("2")));
        BigInteger res2 = getMaxValue(n.divide(new BigInteger("3")));
        BigInteger res3 = getMaxValue(n.divide(new BigInteger("4")));
        BigInteger res = res1.add(res2).add(res3);
        if ( res.compareTo(n) == 1) {
            result[n.intValue()] = res;
        } else {
            result[n.intValue()] = n;
        }
        return result[n.intValue()];
    }
}
