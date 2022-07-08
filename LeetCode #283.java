class Solution {
    public void moveZeroes(int[] nums) {
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (p < 0 && nums[i] == 0)
                p = i;

            if (p < 0 || p == i)
                continue;

            if (nums[i] != 0) {
                nums[p] += nums[i];
                nums[i] = nums[p] - nums[i];
                nums[p] -= nums[i];

                p++;
            }
        }
    }
}