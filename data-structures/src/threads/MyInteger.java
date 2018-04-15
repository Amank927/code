package threads;

import java.util.HashMap;
import java.util.Map;

public class MyInteger
{
    int key;

    public MyInteger(int key)
    {
        this.key = key;
    }

    @Override
    public boolean equals(Object o)
    {
        MyInteger myInteger = (MyInteger) o;
        return key == myInteger.key;
    }

    @Override
    public int hashCode()
    {
        return key%2;
    }

    public static void main(String[] args)
    {
        String str = "dsk w";
        String s1 = "FB";
        String s2 = "Ea";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        Map<String, String> map = new HashMap<>();
        map.put("FB", "az");
        map.put("Ea", "muk");
        System.out.println(map.get("FB"));
        System.out.println(map.get("Ea"));
        Map<MyInteger, String > myMap = new HashMap<>();
        myMap.put(new MyInteger(1), "azhar");
        myMap.put(new MyInteger(3), "mukund");
        System.out.println(myMap.get(new MyInteger(1)));
        System.out.println(myMap.get(new MyInteger(3)));
    }
}
