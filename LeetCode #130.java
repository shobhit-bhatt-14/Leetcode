class Solution {
    public boolean[][] visited = new boolean[200][200];

    public void check(char[][] board, int m, int n, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j] && board[i][j] == 'O') {
            visited[i][j] = true;

            check(board, m, n, i - 1, j);
            check(board, m, n, i, j - 1);
            check(board, m, n, i + 1, j);
            check(board, m, n, i, j + 1);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if (m > 2 && n > 2) {
            for (int i = 0; i < m; i++) {
                check(board, m, n, i, 0);
                check(board, m, n, i, n - 1);
            }

            for (int j = 0; j < n; j++) {
                check(board, m, n, 0, j);
                check(board, m, n, m - 1, j);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }
    }
}