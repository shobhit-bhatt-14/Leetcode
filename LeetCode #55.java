class Solution {
    public boolean canJump(int[] nums) {
        int i = 1, maxPos = nums[0];

        while (i < nums.length && maxPos >= i) {
            if (i + nums[i] > maxPos)
                maxPos = i + nums[i];

            i++;
        }

        if (maxPos >= nums.length - 1)
            return true;
        else
            return false;
    }
}