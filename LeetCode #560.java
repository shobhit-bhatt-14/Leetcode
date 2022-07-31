import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int n : nums) {
            sum += n;

            int key = sum - k;
            if (hmap.containsKey(key))
                count += hmap.get(key);

            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}