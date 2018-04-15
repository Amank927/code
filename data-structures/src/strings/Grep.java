package strings;

import java.util.LinkedList;

public class Grep
{
    public static void printMatches(String[] strings, int k, String match) {
        LinkedList<String> list = new LinkedList<>();

        for(int i=0; i< k && i < strings.length ;i++) {
            list.add(strings[i]);
        }
        int X = k;
        int mi =0;
        for(int i=0; i< strings.length ; i++) {
            if(i+k < strings.length) {
                list.add(strings[i+k]);
            }
            if(list.get(mi++).contains(match)) {
                for(int j=0; j< list.size();j++) {
                    System.out.println(list.get(j));
                }
                System.out.println("--");
            }
            if(X>=0) {
                X--;
            }
            if(X < 0) {
                list.removeFirst();
                mi--;
            }
        }
    }

    public static void main(String[] args)
    {
        String[] strings = new String[]{"a", "b", "a", "b", "c", "a", "b"};
        printMatches(strings, 2, "a");
    }
}
