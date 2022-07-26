import java.util.Arrays;

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;

        int[] temp = Arrays.copyOf(nums, n);

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
            temp[n - 1 - i] += temp[n - i];
        }

        if (temp[1] == 0)
            return 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == temp[i])
                return i;
        }

        if (nums[n - 2] == 0)
            return n - 1;

        return -1;
    }
}