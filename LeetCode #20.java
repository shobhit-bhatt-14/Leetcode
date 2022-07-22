import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0)
            return false;

        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put(']', '[');
        mp.put('}', '{');

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (st.empty())
                return false;
            else if (mp.get(ch) != st.pop())
                return false;
        }

        return st.empty();
    }
}