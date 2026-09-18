package main.java.com.practice.dsa.trie;

public class WordDictionary {
    private static Trie.TrieNode root;

    public WordDictionary() {
        root =  new Trie.TrieNode();
    }

    public static void addWord(String word) {
        Trie.TrieNode current = root;

        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                current.children[index] = new Trie.TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public static boolean search(String word) {

        return search(word, 0, root);

    }

    private static boolean search(String word, int index, Trie.TrieNode current) {

        if(index == word.length()) return current.isEndOfWord;

        char ch = word.charAt(index);
            if(ch != '.') {
                int childIndex = ch - 'a';
                if(current.children[childIndex] == null) return false;
                current = current.children[childIndex];
                return search(word, index+1, current);

            } else {
                for (Trie.TrieNode child: current.children) {
                    if(child != null && search(word, index+1, child)) {
                        return true;
                    }
                }
            }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();

        // Test case 1: Basic word addition and search
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");

        System.out.println("Test 1 - Exact word search:");
        System.out.println("search(\"bad\"): " + wd.search("bad"));      // true
        System.out.println("search(\"dad\"): " + wd.search("dad"));      // true
        System.out.println("search(\"mad\"): " + wd.search("mad"));      // true
        System.out.println("search(\"pad\"): " + wd.search("pad"));      // false

        System.out.println("\nTest 2 - Wildcard search (. matches any single char):");
        System.out.println("search(\".ad\"): " + wd.search(".ad"));      // true (bad, dad, mad)
        System.out.println("search(\"b.d\"): " + wd.search("b.d"));      // true (bad)
        System.out.println("search(\"...\"): " + wd.search("..."));      // true (any 3-char word)
        System.out.println("search(\".a.\"): " + wd.search(".a."));      // true (bad, dad, mad)
        System.out.println("search(\"p.d\"): " + wd.search("p.d"));      // false (no words starting with 'p')

        System.out.println("\nTest 3 - Wildcard edge cases:");
        System.out.println("search(\".....\"): " + wd.search("....."));  // false (no 5-char words)
        wd.addWord("hello");
        System.out.println("After adding \"hello\":");
        System.out.println("search(\"h...o\"): " + wd.search("h...o"));  // true
    }
}
