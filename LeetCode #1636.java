import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        List<Integer> list = new ArrayList<Integer>(freq.keySet());

        Collections.sort(list, (a, b) -> freq.get(a) == freq.get(b) ? b - a : freq.get(a) - freq.get(b));

        int[] ans = new int[nums.length];
        int i = 0;
        for(int n : list) {
            int t = freq.get(n);

            while(t>0) {
                ans[i] = n;
                i++;
                t--;
            }
        }

        return ans;
    }
}