class Solution {
    public void check(char[][] grid, int m, int n, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] != '0') {
            grid[i][j] = '0';

            check(grid, m, n, i - 1, j);
            check(grid, m, n, i, j - 1);
            check(grid, m, n, i + 1, j);
            check(grid, m, n, i, j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    ans++;
                    check(grid, m, n, i, j);
                }
            }
        }

        return ans;
    }
}