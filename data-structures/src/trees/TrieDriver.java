package trees;

public class TrieDriver
{
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.insert("the");
        trie.insert("a");
        trie.insert("there");
        trie.insert("ther");
        trie.insert("their");

        System.out.println(trie.search("theire"));
    }
}
