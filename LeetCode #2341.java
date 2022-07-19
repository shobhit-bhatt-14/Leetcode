import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int n : nums)
            hash.put(n, hash.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int val = entry.getValue();

            if (val == 1)
                ans[1]++;
            else {
                ans[0] += val / 2;
                ans[1] += val % 2;
            }
        }

        return ans;
    }
}