package dataArtisians;

public class SetBits
{
    public static int countSetBits(long num) {
        int count =0;
        while (num > 0) {
            if((num & 1) == 1) {
                count++;
            }
            num =  num >>1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        int n1 = 100000000;
        int n2 = 100000000;
        long nn1 = (long) n1;
        long nn2 = (long) n2;
        long val = nn1 *nn2;
        System.out.println(val);
        System.out.println(countSetBits(11*1));
        System.out.println(countSetBits(val));
        //System.out.println(countSetBits(Long.MAX_VALUE));
        //System.out.println(String.valueOf(Long.MAX_VALUE).length());
    }
}


// 10101