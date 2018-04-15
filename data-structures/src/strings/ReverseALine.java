package strings;

public class ReverseALine
{
    public static String reverse(String string) {
        return reverseWithIndex(string);
    }

    public static String reverseWithIndex(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = str.length() -1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static String reverseWords(String a) {
        String stringWithoutSpaces = getStringWithoutSpaces(a);
        String reversed = reverse(stringWithoutSpaces);
        String finalRes = "";
        int start =0;
        int end =0;
        int i =0;
        while (i< reversed.length()) {
            if (reversed.charAt(i) !=' ') {
                end++;
            } else if(reversed.charAt(i) == ' '){
                finalRes = finalRes + reverseWithIndex(reversed.substring(start, end)) + " ";
                start = i+1;
            }
            i++;
        }
        finalRes = finalRes + reverseWithIndex(reversed.substring(start, reversed.length()));
        return finalRes;

    }

    private static String getStringWithoutSpaces(String a)
    {
        char[] arr = new char[a.length()];

        int i=0;
        while(a.charAt(i) == ' ') {
            i++;
        }
        int lastSpace = -1;
        int start =0;
        for (int j =i;j<a.length();j++) {
            if(a.charAt(j) != ' ') {
                arr[start++] = a.charAt(j);
                lastSpace = -1;
            }
            else if(a.charAt(j) == ' ' && lastSpace == -1) {
                arr[start++] = a.charAt(j);
                lastSpace = 1;
            } else {
                j++;
            }
        }

        return String.copyValueOf(arr, 0, start);
    }

    public static void main(String[] args)
    {
        System.out.println(reverseWords("the sky is blue"));
    }
}
