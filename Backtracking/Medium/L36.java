package Backtracking.Medium;

// 36. Valid Sudoku

import java.util.HashSet;
import java.util.Set;

public class L36 {

    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " is present at row " + i)
                            || !seen.add(board[i][j] + " is present at col " + j)
                            || !seen.add(board[i][j] + " is present at block  " + i / 3 + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.print(new L36().isValidSudoku(board));
    }
}

// Time Complexity - O(M * N)
// Time Complexity - O(M)