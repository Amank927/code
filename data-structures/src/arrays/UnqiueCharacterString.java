package arrays;

import java.util.HashSet;
import java.util.Set;

public class UnqiueCharacterString
{
    public static void main(String[] args)
    {
        String str1 = "!bcdea";
        System.out.println((int) str1.charAt(0));
        Set<Character> characterSet = new HashSet<>();
        for ( int i =0; i<str1.length(); i++)
        {
            if ( characterSet.contains(str1.charAt(i))) {
                System.out.println("Non unique character found "+ str1.charAt(i));
                System.exit(0);
            } else {
                characterSet.add(str1.charAt(i));
            }
        }
        System.out.println("All chars are unique");
    }
}
