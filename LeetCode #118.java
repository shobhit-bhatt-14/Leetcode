class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> row = new ArrayList<>(Arrays.asList(1));
        ans.add(row);

        if (numRows == 1)
            return ans;

        row = Arrays.asList(1, 1);
        ans.add(row);

        if (numRows == 2)
            return ans;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();

            list.add(1);

            List<Integer> prev = ans.get(i - 2);
            for (int j = 0; j < prev.size() - 1; j++)
                list.add(prev.get(j) + prev.get(j + 1));

            list.add(1);

            ans.add(list);
        }

        return ans;
    }
}