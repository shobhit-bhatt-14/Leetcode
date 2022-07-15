class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;

            if (target >= nums[0] && nums[mid] < nums[0])
                end = mid - 1;
            else if (target < nums[0] && nums[mid] >= nums[0])
                start = mid + 1;
            else {
                if (nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return -1;
    }
}