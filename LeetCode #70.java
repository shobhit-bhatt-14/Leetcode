class Solution {
    public Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return noOfWays(0, n);
    }

    public int noOfWays(int i, int n) {
        if (i > n)
            return 0;
        else if (i == n)
            return 1;
        else {
            if (map.containsKey(i))
                return map.get(i);
            else {
                int value = noOfWays(i + 1, n) + noOfWays(i + 2, n);
                map.put(i, value);
                return value;
            }
        }
    }
}