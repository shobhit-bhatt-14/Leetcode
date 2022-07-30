import java.util.*;

class Solution {
    public HashMap<Character, Integer> getFreq(String s) {
        HashMap<Character, Integer> m = new HashMap<>();

        for (char ch : s.toCharArray()) {
            int value = 1;

            if (m.containsKey(ch))
                value += m.get(ch);

            m.put(ch, value);
        }

        return m;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> hmap = new HashMap<>();

        for (String word2 : words2) {
            HashMap<Character, Integer> temp = getFreq(word2);

            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                if (entry.getValue() > hmap.getOrDefault(entry.getKey(), 0))
                    hmap.put(entry.getKey(), entry.getValue());
            }
        }

        for (String word1 : words1) {
            HashMap<Character, Integer> temp = getFreq(word1);
            boolean universal = true;

            for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
                if (temp.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    universal = false;
                    break;
                }
            }

            if (universal)
                ans.add(word1);
        }

        return ans;
    }
}