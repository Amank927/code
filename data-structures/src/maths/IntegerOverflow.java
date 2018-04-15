package maths;

public class IntegerOverflow
{
    public static int reverse(int a) {
        int res = 0;
        boolean neg = false;
        try {
            if (a < 0) {
                neg = true;
                a = a*-1;
            }
         while( a > 0) {
            res = Math.addExact(Math.multiplyExact(res,10) , a%10);
            a = a/10;
        }
        if (neg) {
            return Math.multiplyExact(res,-1);
        } else{
            return res;
        }
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        int x=-146467285;
        System.out.println(reverse(x));
    }
}
