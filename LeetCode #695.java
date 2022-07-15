class Solution {
    public int calculateArea(int[][] grid, int m, int n, int i, int j) {
        int area = 1;

        grid[i][j] = 0;

        // top
        if ((i - 1 >= 0) && (grid[i - 1][j] == 1))
            area += calculateArea(grid, m, n, i - 1, j);

        // left
        if ((j - 1 >= 0) && (grid[i][j - 1] == 1))
            area += calculateArea(grid, m, n, i, j - 1);

        // bottom
        if ((i + 1 < m) && (grid[i + 1][j] == 1))
            area += calculateArea(grid, m, n, i + 1, j);

        // right
        if ((j + 1 < n) && (grid[i][j + 1] == 1))
            area += calculateArea(grid, m, n, i, j + 1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ans = Math.max(ans, calculateArea(grid, m, n, i, j));
            }
        }

        return ans;
    }
}