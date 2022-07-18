class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;

        if (rows == 1 && cols == 1)
            return (matrix[0][0] == target) ? 1 : 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < cols; i++) {
            for (int j = i; j < cols; j++) {
                hmap.clear();
                hmap.put(0, 1);
                int sum = 0;

                for (int k = 0; k < rows; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);

                    ans += hmap.getOrDefault(sum - target, 0);

                    hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return ans;
    }
}