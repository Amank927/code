package trees;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HotelReviews
{
    class TrieNode {
        TrieNode[] chid = new TrieNode[26];
        boolean isE ;

        public TrieNode()
        {
            for(int i=0; i< 26 ;i++) {
                this.chid[i] = null;
            }
            this.isE = false;
        }
    }

    public TrieNode root;

    public HotelReviews()
    {
        root = new TrieNode();
    }

    public void addWord(String string) {

        TrieNode temp = root;
        for(int i=0; i< string.length() ;i++) {
            if(temp.chid[string.charAt(i) - 'a'] == null) {
                temp.chid[string.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.chid[string.charAt(i) - 'a'];
        }
        temp.isE = true;
    }

    public boolean search(String string) {
        TrieNode temp = root;
        for(int i=0; i< string.length() ;i++) {
            if(temp.chid[string.charAt(i) - 'a'] == null) {
                return false;
            } else {
                temp = temp.chid[string.charAt(i) - 'a'];
            }
        }
        return temp.isE;
    }
    static class KV {
        int k;
        int v;

        public KV(int k, int v)
        {
            this.k = k;
            this.v = v;
        }
    }
    public static void main(String[] args)
    {
        HotelReviews hotelReviews = new HotelReviews();
        hotelReviews.addWord("cool");
        hotelReviews.addWord("ice");
        hotelReviews.addWord("wifi");

        System.out.println(hotelReviews.search("cool"));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });
        treeMap.put(0, 1);
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        for(Map.Entry<Integer, Integer> entry :treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
