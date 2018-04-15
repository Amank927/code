package trees;

public class Trie
{
    class TrieNode
    {
        private TrieNode[] children = new TrieNode[26];

        private boolean isEndOfWord ;

        public TrieNode()
        {
            for (int i=0; i<26 ; i++) {
                children[i] = null;
            }
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String string)
    {
        int length = string.length();

        TrieNode current = root;
        for (int i=0; i< length ;i++) {
            int index = string.charAt(i) - 'a';

            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String string) {
        int length = string.length();
        int i=0;
        TrieNode current = root;
        while (i < length) {
            int index = string.charAt(i) -'a';
            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
                i++;
            }
        }
        if(current!=null && current.isEndOfWord) {
            return true;
        }
        return false;

    }
}
