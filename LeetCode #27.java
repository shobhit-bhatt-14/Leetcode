class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        int i = 0;

        while (i < ans) {
            if (nums[i] == val) {
                nums[i] = nums[ans-1];
                ans--;
                continue;
            }
            i++;
        }

        return ans;
    }
}