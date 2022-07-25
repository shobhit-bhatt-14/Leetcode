import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> hmap = new HashMap<>();

        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            int key = target - nums[i];

            if (hmap.containsKey(key)) {
                ans[0] = hmap.get(key);
                ans[1] = i;
                break;
            }

            hmap.put(nums[i], i);
        }

        return ans;
    }
}