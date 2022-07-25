class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2))
            return text1.length();

        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];

        return calculateSubsequence(text1, text2, m - 1, n - 1);
    }

    public int calculateSubsequence(String text1, String text2, int index1, int index2) {
        if (index1 < 0 || index2 < 0)
            return 0;

        if (dp[index1][index2] != 0)
            return dp[index1][index2];

        if (text1.charAt(index1) == text2.charAt(index2))
            dp[index1][index2] = 1 + calculateSubsequence(text1, text2, index1 - 1, index2 - 1);
        else
            dp[index1][index2] = Math.max(calculateSubsequence(text1, text2, index1 - 1, index2),
                    calculateSubsequence(text1, text2, index1, index2 - 1));

        return dp[index1][index2];
    }
}