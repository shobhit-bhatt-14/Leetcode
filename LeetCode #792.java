import java.util.HashMap;

class Solution {
    public HashMap<String, Boolean> dp = new HashMap<>();

    public boolean check(String s, String word) {
        int sLen = s.length();
        int wLen = word.length();

        if (sLen < wLen)
            return false;

        String key = word;
        if (dp.containsKey(key))
            return dp.get(key);

        int prev = -1;
        for (int i = 0; i < wLen; i++) {
            int j = s.indexOf(word.charAt(i), prev + 1);

            if (j == -1) {
                dp.put(key, false);
                return false;
            } else {
                prev = j;
            }
        }

        dp.put(key, true);
        return true;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;

        for (String word : words) {
            if (check(s, word))
                ans++;
        }

        return ans;
    }
}