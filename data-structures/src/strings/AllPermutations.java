package strings;

public class AllPermutations
{
    public static void printAllPer(char[] str, int ind) {
        if (ind == str.length) {
            System.out.println(str);
        }

        for (int j = ind ;j < str.length ;j++) {
            char temp = str[ind];
            str[ind] = str[j];
            str[j] = temp;
            printAllPer(str, ind + 1);
            temp = str[ind];
            str[ind] = str[j];
            str[j] = temp;
        }
    }
    public static void main(String[] args)
    {
        String string = "ABC";
        char[] characters = string.toCharArray();
        printAllPer(string.toCharArray(), 0);
    }
}
