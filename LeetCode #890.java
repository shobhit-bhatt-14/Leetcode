import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int len = pattern.length();

        if (len == 1) {
            return Arrays.asList(words);
        }

        List<String> ans = new ArrayList<>();

        pattern = changeStr(pattern, len);
        System.out.println(pattern);

        for (String word : words) {
            String temp = changeStr(word, len);
            System.out.println(temp);

            if (temp.equals(pattern))
                ans.add(word);
        }

        return ans;
    }

    public String changeStr(String word, int len) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        String str = "";
        int val = 1;

        for (char c : word.toCharArray()) {
            if (!hmap.containsKey(c)) {
                hmap.put(c, val);
                val++;
            }

            str += String.valueOf(hmap.get(c)) + "-";
        }

        return str;
    }
}