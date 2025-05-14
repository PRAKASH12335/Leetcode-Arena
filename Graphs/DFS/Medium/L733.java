package Graphs.DFS.Medium;

// 733. Flood Fill

public class L733 {
    private void dfs(int r, int c, int m, int n, int newColor, int oldColor, int[][] image, int[][] ans) {
        ans[r][c] = newColor;
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dirX[i];
            int nc = c + dirY[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                dfs(nr, nc, m, n, newColor, oldColor, image, ans);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int iniColor = image[sr][sc];
        int[][] ans = image;
        dfs(sr, sc, m, n, color, iniColor, image, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        L733 obj = new L733();
        int[][] ans = obj.floodFill(image, sr, sc, color);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)