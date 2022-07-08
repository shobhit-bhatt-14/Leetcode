class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans = 0, range = 1, current, next;

        for (int i = inventory.length - 1; i >= 0; i--) {
            if (i != 0 && inventory[i] == inventory[i - 1]) {
                range++;
                continue;
            }

            current = inventory[i];
            next = (i == 0) ? 0 : inventory[i - 1];

            if ((current - next) * range <= orders) {
                ans += (findSum(current, next) * range) % 1000000007;
                orders -= (current - next) * range;
            } else {
                long multiple = orders / range;
                ans += (findSum(current, current - multiple) * range) % 1000000007;
                long remainder = orders % range;
                ans += ((current - multiple) * remainder) % 1000000007;
                orders = 0;
            }

            range++;

            if (orders <= 0)
                break;
        }

        return (int) (ans % 1000000007);
    }

    public long findSum(long start, long end) {
        long res = ((start * (start + 1)) - (end * (end + 1))) / 2;
        return res % 1000000007;
    }
}