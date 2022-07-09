class Solution {
    public void sortColors(int[] nums) {
        int i = 0, left = 0, right = nums.length - 1;

        while (i <= right) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;

                left++;
                i++;

            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;

                right--;
            } else {
                i++;
            }
        }
    }
}