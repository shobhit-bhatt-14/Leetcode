import java.util.HashMap;

class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(hmap.containsKey(s.charAt(i)))
                return s.charAt(i);
            
            hmap.put(s.charAt(i), 1);
        }

        return 'a';
    }
}