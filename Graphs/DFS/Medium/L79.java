package Graphs.DFS.Medium;

// 79. Word Search

public class L79 {
    private boolean dfs(int i, int j, char[][] board, String word, int count) {
        if (count == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(count) != board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(i + 1, j, board, word, count + 1) ||
                dfs(i - 1, j, board, word, count + 1) ||
                dfs(i, j + 1, board, word, count + 1) ||
                dfs(i, j - 1, board, word, count + 1);
        board[i][j] = temp;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new L79().exist(board, word));
    }
}

// Time Complexity - O(4^n * m)
// Space Complexity - O(m)
// m = length of the word, n = number of cells in the board