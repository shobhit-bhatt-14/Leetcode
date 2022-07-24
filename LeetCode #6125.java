import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;

        HashMap<String, Integer> mapR = new HashMap<>();
        HashMap<String, Integer> mapC = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String keyR = "";
            String keyC = "";

            for (int j = 0; j < n; j++) {
                keyR += String.valueOf(grid[i][j]) + "*";
                keyC += String.valueOf(grid[j][i]) + "*";
            }

            int valR = mapR.getOrDefault(keyR, 0);
            int valC = mapC.getOrDefault(keyC, 0);

            mapR.put(keyR, valR + 1);
            mapC.put(keyC, valC + 1);
        }

        for (Entry<String, Integer> entry : mapR.entrySet()) {
            String key = entry.getKey();

            int valR = mapR.getOrDefault(key, 0);
            int valC = mapC.getOrDefault(key, 0);

            ans += valR * valC;
        }

        return ans;
    }
}