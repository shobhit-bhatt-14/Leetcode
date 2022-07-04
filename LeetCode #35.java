class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start+end)/2;

            if(nums[mid] < target)
                start = mid+1;

            else {
                ans = mid;
                end = mid-1;
            }
        }

        return ans;
    }
}