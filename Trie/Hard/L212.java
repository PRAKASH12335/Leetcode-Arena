package Trie.Hard;

// 212. Word Search II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
    }
}

public class L212 {
    TrieNode root;
    List<String> ans;

    public void insert(String word) {
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

    public void dfs(char[][] board, boolean[][] vis, int r, int c, String s, TrieNode root) {
        int m = board.length, n = board[0].length;
        if (root.isWord) {
            ans.add(s);
            root.isWord = false;
        }
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nr = r + dirX[i];
            int nc = c + dirY[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    vis[nr][nc] == false && root.children.containsKey(board[nr][nc])) {
                vis[nr][nc] = true;
                dfs(board, vis, nr, nc, s + board[nr][nc], root.children.get(board[nr][nc]));
                vis[nr][nc] = false;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    boolean[][] vis = new boolean[m][n];
                    vis[i][j] = true;
                    dfs(board, vis, i, j, "" + board[i][j], root.children.get(board[i][j]));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new L212().findWords(board, words));
    }
}

// Time Complexity - O(N*L + M*N)
// Space Complexity - O(M*N)