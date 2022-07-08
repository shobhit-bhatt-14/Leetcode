class Solution {
    private HashMap<String, Boolean> memo = new HashMap<>();

    private boolean checkInterleave(String s1, int p1, String s2, int p2, String s3, int p3) {
        if (p3 == s3.length())
            return (p1 == s1.length() && p2 == s2.length()) ? true : false;

        String key = String.valueOf(p1) + "-" + String.valueOf(p2) + "-" + String.valueOf(p3);
        if(memo.containsKey(key))
            return memo.get(key);

        if(p1 == s1.length()) {
            boolean value = (s2.charAt(p2) == s3.charAt(p3)) ? checkInterleave(s1, p1, s2, p2+1, s3, p3+1) : false;
            memo.put(key, value);
            return memo.get(key);
        }

        if(p2 == s2.length()) {
            boolean value = (s1.charAt(p1) == s3.charAt(p3)) ? checkInterleave(s1, p1+1, s2, p2, s3, p3+1) : false;
            memo.put(key, value);
            return memo.get(key);
        }

        boolean val = false;
        if(s1.charAt(p1) == s3.charAt(p3))
            val = val || checkInterleave(s1, p1+1, s2, p2, s3, p3+1);
        if(s2.charAt(p2) == s3.charAt(p3))
            val = val || checkInterleave(s1, p1, s2, p2+1, s3, p3+1);

        memo.put(key, val);
        return memo.get(key);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        return checkInterleave(s1, 0, s2, 0, s3, 0);
    }
}