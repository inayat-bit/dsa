package main.java.com.practice.dsa.trie;

public class Trie {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        String word;
    }

    private static TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public static void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;

    }

    public static boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEndOfWord;

    }

    public static boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        insert("apple");
        insert("app");
        insert("bat");

        System.out.println("search(\"apple\"): " + search("apple"));     // true
        System.out.println("search(\"app\"): " + search("app"));         // true
        System.out.println("search(\"appl\"): " + search("appl"));       // false
        System.out.println("startsWith(\"ap\"): " + startsWith("ap"));   // true
        System.out.println("startsWith(\"ba\"): " + startsWith("ba"));   // true
        System.out.println("startsWith(\"cat\"): " + startsWith("cat")); // false
    }


}
