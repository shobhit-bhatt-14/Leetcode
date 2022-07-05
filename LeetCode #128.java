class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hSet = new HashSet<>();

        for (int num : nums)
            hSet.add(num);

        int maxLength = 0;
        for (int n : hSet) {
            int i = n, count = 0;
            if (!hSet.contains(i - 1)) {
                while (hSet.contains(i)) {
                    count++;
                    i++;
                }
            }

            if (count > maxLength) {
                maxLength = count;
            }
        }

        return maxLength;
    }
}