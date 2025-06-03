package Trie.Medium;

// 1268. Search Suggestions System

import java.util.ArrayList;
import java.util.List;

class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }

    public void addWord(String word, Trie root) {
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new Trie();
            }
            root = root.children[c - 'a'];
        }
        root.isWord = true;
    }

    public List<String> searchWords(String word, Trie root) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            if (root.children[c - 'a'] == null) {
                return words;
            }
            root = root.children[c - 'a'];
        }
        dfs(word, words, root);
        return words;
    }

    public void dfs(String word, List<String> words, Trie root) {
        if (words.size() == 3)
            return;
        if (root.isWord == true) {
            words.add(word);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (root.children[c - 'a'] != null)
                dfs(word + c, words, root.children[c - 'a']);
        }
    }
}

public class L1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (int i = 0; i < products.length; i++) {
            root.addWord(products[i], root);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            ans.add(root.searchWords(searchWord.substring(0, i), root));
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new L1268().suggestedProducts(products, searchWord));
    }
}

// Time Complexity - O(L * m * l): where L == searchWord length
//                               : m == products array length
//                               : l == max length of products
// Space Complexity - O(m * l)