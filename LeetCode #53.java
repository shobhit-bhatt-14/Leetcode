class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;

        for (int n : nums) {
            if (sum + n > ans)
                ans = sum + n;

            sum = (sum + n < 0) ? 0 : sum + n;
        }

        return ans;
    }
}