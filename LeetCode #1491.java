import java.util.*;

class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);

        double sum = 0;
        int n = salary.length;

        for(int i=1; i<n-1; i++)
            sum += salary[i];

        sum /= n-2;

        return sum;
    }
}