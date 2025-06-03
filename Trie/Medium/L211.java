package Trie.Medium;

// 211. Design Add and Search Words Data Structure

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        this.children = new HashMap<>();
    }
}

public class L211 {
    TrieNode root;

    L211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, child, index + 1))
                    return true;
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) return false;
            return searchHelper(word, node.children.get(c), index + 1);
        }
    }

    public static void main(String[] args) {
        L211 wordDictionary = new L211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)