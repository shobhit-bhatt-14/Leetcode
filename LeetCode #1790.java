class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int counter = 0;
        char x = '_';
        char y = '_';

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (counter == 0) {
                    x = s1.charAt(i);
                    y = s2.charAt(i);
                } else {
                    if (s1.charAt(i) != y || s2.charAt(i) != x)
                        return false;
                }

                counter++;
            }

            if (counter > 2)
                return false;
        }

        return (counter == 2) ? true : false;
    }
}