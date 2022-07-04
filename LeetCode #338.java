class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0 ; i<n+1 ; i++) {
            ans[i] = getNoOfSetBits(i);
        }

        return ans;
    }

    public int getNoOfSetBits(int num) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) > 0)
                count++;
        }

        return count;
    }
}