class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1, flag = 0;

        for (int i = 1; i < nums.length; i++) {
            if (flag == 0) {
                if (nums[i] - nums[i - 1] > 0) {
                    flag = 1;
                    ans++;
                } else if (nums[i] - nums[i - 1] < 0) {
                    flag = -1;
                    ans++;
                }
            } else if (nums[i] - nums[i - 1] > 0 && flag < 0) {
                ans++;
                flag = 1;
            } else if (nums[i] - nums[i - 1] < 0 && flag > 0) {
                ans++;
                flag = -1;
            }
        }

        return ans;
    }
}