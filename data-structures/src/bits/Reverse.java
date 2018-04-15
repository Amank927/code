package bits;

public class Reverse
{
    public static long reverse(long a) {
        long res = 0;
        long n1 = 1, n2 = 1;
        for(int i=0; i<32 ; i++) {
            n1 = 1 << i;
            //System.out.println(n1);
            if((n1 & a) != 0) {
                res = res | 1 << (32 -i -1);
            }
            //System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args)
    {
        long res = 1 << 30;
        String string = Long.toBinaryString(res);
        System.out.println(string);
        string = "00000000000000000000000000000011";
        System.out.println(string.length());
        System.out.println(reverse(3));
    }
}
