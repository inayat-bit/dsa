package main.java.com.practice.dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch2 {
    private static Trie.TrieNode root = new Trie.TrieNode();
    private static List<String> result = new ArrayList<>();
    public static List<String> findWords(List<String> words, char[][] boards) {
        for(String word : words) {
            insert(word);
        }

        for(int i = 0; i < boards.length; i++) {
            for(int j = 0; j < boards[0].length; j++) {
                dfs(boards, i, j, root);
            }
        }
        return result;
    }

    private static void insert(String word) {
        Trie.TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                current.children[index]  = new Trie.TrieNode();
            }
            current = current.children[index];
        }
        current.word = word;
    }

    private static void dfs(char[][] boards, int row, int col, Trie.TrieNode node) {
        if (row < 0 || row >= boards.length ||
                col < 0 || col >= boards[0].length) {
            return;
        }
        char ch = boards[row][col];
        if(ch == '#') return;
        int index = ch - 'a';
        if(node.children[index] == null) return;
        Trie.TrieNode next = node.children[index];
        if(next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        boards[row][col] = '#';
        dfs(boards, row+1, col, next);
        dfs(boards, row-1, col, next);
        dfs(boards, row, col-1, next);
        dfs(boards, row, col+1, next);
        boards[row][col] = ch;
    }

    public static void main(String[] args) {
        root = new Trie.TrieNode();
        result = new ArrayList<>();

        List<String> words = Arrays.asList("oath", "pea", "eat", "rain");
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        System.out.println(findWords(words, board));
    }
}
