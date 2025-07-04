package DynamicProgramming.Hard;

// 140. Word Break II

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class L140 {
    public void helper(List<String> ans, String s, List<String> wordDict, StringBuilder sb) {
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            String t = s.substring(0, i);
            if (wordDict.contains(t)) {
                if (i == n) {
                    sb.append(t);
                    ans.add(sb.toString());
                    return;
                }
                int len = sb.length();
                sb.append(t).append(" ");
                helper(ans, s.substring(i), wordDict, sb);
                sb.setLength(len);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        helper(ans, s, wordDict, new StringBuilder());
        return ans;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new L140().wordBreak(s, wordDict));
    }
}

// Time Complexity - O(M * N * 2^N)
// Space Complexity - O(N)