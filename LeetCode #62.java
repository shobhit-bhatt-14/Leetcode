import java.util.*;

class Solution {
    public HashMap<String, Integer> hmap = new HashMap<>();

    public int uniquePaths(int m, int n) {
        return calculate(0, 0, m, n, 0);
    }

    public int calculate(int i, int j, int m, int n, int count) {
        String key = String.valueOf(i) + ":" + String.valueOf(j);

        if (hmap.containsKey(key))
            return hmap.get(key);

        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        count += calculate(i + 1, j, m, n, count) + calculate(i, j + 1, m, n, count);

        hmap.put(key, count);
        return count;
    }
}