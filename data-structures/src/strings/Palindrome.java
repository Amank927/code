package strings;

public class Palindrome
{
    public static int isPalindrome(String a) {
        int i = 0;
        int j = a.length() -1 ;
        String b = a.toLowerCase();
        while (i< j ) {
            if (!(Character.isAlphabetic(b.charAt(i)) || Character.isDigit(b.charAt(i)))) {
                i++;
                continue;
            }
            if (!(Character.isAlphabetic(b.charAt(j)) || Character.isDigit(b.charAt(j)))) {
                j--;
                continue;
            }
            if (b.charAt(i) != b.charAt(j)) {
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args)
    {
        String str = "wdcb";
        str.charAt(0);
        Character.toLowerCase(str.charAt(0));
        System.out.println(isPalindrome("race a car"));
    }
}
