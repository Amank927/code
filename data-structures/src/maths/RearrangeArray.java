package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArray
{
    public static void arrange(ArrayList<Integer> a) {

        for(int i=0; i<a.size() ;i++) {
            int curr = a.get(i);

            for (int j=0;j< a.size() ;j++) {
                if(a.get(j) == i) {
                    a.set(j, -1*curr) ;
                }
            }
            for (int k=0;k<a.size() ;k++)
            {
                System.out.print(a.get(k));
            }
            System.out.println();
        }

        for (int i=0;i<a.size() ;i++)
        {
            a.set(i, a.get(i)*-1);
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(4);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrange(arrayList);
    }
}
