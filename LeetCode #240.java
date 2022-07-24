class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;

        return findTarget(matrix, target, matrix.length - 1, 0, n);
    }

    public boolean findTarget(int[][] matrix, int target, int row, int col, int n) {
        if (row < 0 || col >= n)
            return false;

        if (matrix[row][col] == target)
            return true;
        else if (matrix[row][col] > target)
            return findTarget(matrix, target, row - 1, col, n);
        else
            return findTarget(matrix, target, row, col + 1, n);
    }
}