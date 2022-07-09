class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(int)(nums.length / 2)];
    }
}