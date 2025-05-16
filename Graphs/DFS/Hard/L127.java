package Graphs.DFS.Hard;

// 127. Word Ladder

import java.util.*;

class Node {
    String word;
    int sequence;

    public Node(String word, int sequence) {
        this.word = word;
        this.sequence = sequence;
    }
}

public class L127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, 1));
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Node node = q.poll();
            String curr = node.word;
            int steps = node.sequence;
            if (curr.equals(endWord)) return steps;
            for (int i = 0; i < curr.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = curr.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        q.add(new Node(replacedWord, steps + 1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new L127().ladderLength(beginWord, endWord, wordList));
    }
}

// Time Complexity - O(N * M * 26)
// Space Complexity - O(N)