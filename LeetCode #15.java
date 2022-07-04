class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || (i - 1 >= 0 && nums[i - 1] != nums[i])) {
                int target = -nums[i];
                List<List<Integer>> pairs = twoSum(nums, i + 1, nums.length - 1, target);

                for (List<Integer> pair : pairs) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(pair.get(0));
                    triplet.add(pair.get(1));

                    triplets.add(triplet);
                }
            }
        }

        return triplets;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        int first = start, last = end;

        while (first < last) {
            if (first - 1 >= start && nums[first - 1] == nums[first]) {
                first++;
                continue;
            }
            if (last + 1 <= end && nums[last] == nums[last + 1]) {
                last--;
                continue;
            }

            if (nums[first] + nums[last] > target)
                last--;
            else if (nums[first] + nums[last] < target)
                first++;
            else {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[first]);
                pair.add(nums[last]);

                pairs.add(pair);
                first++;
            }
        }

        return pairs;
    }
}