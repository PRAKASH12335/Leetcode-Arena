package Graphs.DFS.Medium;

// 130. Surrounded Regions

public class L130 {
    private void dfs(int i, int j, int m, int n, char[][] board, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == '#')
            return;
        board[i][j] = '#';
        dfs(i + 1, j, m, n, board, vis);
        dfs(i - 1, j, m, n, board, vis);
        dfs(i, j + 1, m, n, board, vis);
        dfs(i, j - 1, m, n, board, vis);
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(i, j, m, n, board, vis);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new L130().solve(board);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)