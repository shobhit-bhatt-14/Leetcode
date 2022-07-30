class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        long product = 1;
        boolean pro = true;

        while (n != 0) {
            int digit = n % 10;
            sum += digit;

            if (pro)
                product *= digit;

            if (digit == 0)
                pro = false;

            n /= 10;
        }

        return (int) product - sum;
    }
}