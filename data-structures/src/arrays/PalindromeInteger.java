package arrays;

public class PalindromeInteger
{
    public static boolean isPalindrome(int a) {
        boolean isPalin = true;
        if (a < 0) {
            return false;
        }
        if (a < 9) {
            return true;
        }
        int res = 0;
        int copy = a;
        while (copy > 0) {
            res = res*10 + copy%10;
            copy = copy/10;
        }
        if (res == a) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome(9));
    }
}
