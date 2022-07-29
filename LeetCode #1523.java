class Solution {
    public int countOdds(int low, int high) {
        int ans = (high - low) / 2;

        return ((low & 1) == 1 || (high & 1) == 1) ? ans + 1 : ans;
    }
}