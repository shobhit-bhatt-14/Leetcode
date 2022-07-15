class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]] ^= true;
            cols[indices[i][1]] ^= true;
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < m; i++) {
            if (rows[i])
                row++;
        }

        for (int j = 0; j < n; j++) {
            if (cols[j])
                col++;
        }

        return (row * n) + (col * m) - (2 * row * col);
    }
}