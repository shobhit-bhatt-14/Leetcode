import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<Integer>();

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(0);
            list.add(Arrays.asList(nums[i], i));
        }

        if (n == 1)
            return ans;

        sort(ans, list, 0, n - 1);

        return ans;
    }

    public void sort(List<Integer> ans, List<List<Integer>> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(ans, list, left, mid);
            sort(ans, list, mid + 1, right);

            merge(ans, list, left, mid, right);
        }
    }

    public void merge(List<Integer> ans, List<List<Integer>> list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        List<List<Integer>> temp = new ArrayList<>(Collections.nCopies(right - left + 1, Arrays.asList(0, 0)));

        while (i <= mid && j <= right) {
            if (list.get(i).get(0) > list.get(j).get(0)) {
                int index = list.get(i).get(1);
                ans.set(index, ans.get(index)+right - j + 1);

                temp.set(k, list.get(i));
                i++;
            } else {
                temp.set(k, list.get(j));
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp.set(k, list.get(i));

            i++;
            k++;
        }

        while (j <= right) {
            temp.set(k, list.get(j));

            j++;
            k++;
        }

        for (int x = left; x <= right; x++) {
            list.set(x, temp.get(x - left));
        }
    }
}