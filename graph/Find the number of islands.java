class Solution {
    static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    void dfs (int r, int c, char[][] grid, boolean[][] vis, int n, int m) {
        vis[r][c] = true;
        for (int i = 0; i < dirs.length; ++i) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (nr >= 0 && nr <  n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 'L')
                dfs (nr, nc, grid, vis, n, m);
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 'L' && !vis[i][j]) {
                    dfs (i, j, grid, vis, n, m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}