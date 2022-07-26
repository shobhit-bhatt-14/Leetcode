import java.util.Arrays;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] from = new int[n];
        int[] to = new int[n];

        Arrays.fill(from, 0);
        Arrays.fill(to, 0);

        for (int i = 0; i < trust.length; i++) {
            from[trust[i][0] - 1]++;
            to[trust[i][1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (from[i] == 0 && to[i] == n - 1)
                return i + 1;
        }

        return -1;
    }
}