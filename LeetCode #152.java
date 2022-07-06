class Solution {
    public int maxProduct(int[] nums) {
        int ans = 0, product = 1;

        if (nums.length == 1)
            return nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
                ans = Math.max(ans, product);
            } else
                product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                product *= nums[i];
                ans = Math.max(ans, product);
            } else
                product = 1;
        }

        return ans;
    }
}