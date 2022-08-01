import java.util.*;

class Solution {
    public HashSet<Integer> hset = new HashSet<>();

    public boolean isHappy(int n) {
        int sum = 0;

        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        if (sum == 1)
            return true;
        else if (hset.contains(sum))
            return false;
        else {
            hset.add(sum);
            return isHappy(sum);
        }
    }
}