import java.util.*;

class Solution {
    public String sortString(String word) {
        char[] temp = word.toCharArray();

        Arrays.sort(temp);

        return new String(temp);
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hset = new HashSet<>();

        for (String word : words) {
            String str = sortString(word);

            if (!hset.contains(str)) {
                ans.add(word);
                hset.clear();
                hset.add(str);
            }
        }

        return ans;
    }
}