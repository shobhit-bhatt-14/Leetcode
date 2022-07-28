import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char x : s.toCharArray())
            smap.put(x, smap.getOrDefault(x, 0) + 1);

        for (char x : t.toCharArray())
            tmap.put(x, tmap.getOrDefault(x, 0) + 1);

        return smap.equals(tmap);
    }
}