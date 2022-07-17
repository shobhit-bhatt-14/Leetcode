class Solution {
    public HashMap<String, Integer> memo = new HashMap<String, Integer>();

    public int calculateWays(int m, int n, int maxMove, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;

        if (maxMove <= 0)
            return 0;

        String key = String.valueOf(i) + "-" + String.valueOf(j) + "-" + String.valueOf(maxMove);
        if (memo.containsKey(key))
            return memo.get(key);

        long value = 0;

        value += calculateWays(m, n, maxMove - 1, i - 1, j);
        value += calculateWays(m, n, maxMove - 1, i, j - 1);
        value += calculateWays(m, n, maxMove - 1, i + 1, j);
        value += calculateWays(m, n, maxMove - 1, i, j + 1);

        value = value % 1000000007;
        memo.put(key, (int)value);
        return (int)value;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return calculateWays(m, n, maxMove, startRow, startColumn) % 1000000007;
    }
}