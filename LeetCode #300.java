class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[n - 1] = 1;

        int ans = 1;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }

            dp[i]++;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}