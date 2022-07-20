import java.util.HashMap;

class Solution {
    public HashMap<String, Integer> dp = new HashMap<>();

    public int calculateWays(int[] nums, int n, int index, int target) {
        if (index == n)
            return (Math.abs(target) == nums[n]) ? ((nums[n] == 0) ? 2 : 1) : 0;

        String key = String.valueOf(index) + "*" + String.valueOf(target);
        if (!dp.containsKey(key)) {
            int value = calculateWays(nums, n, index + 1, target + nums[index])
                    + calculateWays(nums, n, index + 1, target - nums[index]);

            dp.put(key, value);
        }
        return dp.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length - 1;

        return calculateWays(nums, n, 0, target);
    }
}