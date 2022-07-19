class Solution {
    public HashMap<Integer, Integer> dp = new HashMap<>();

    public int getCoins(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        if (dp.containsKey(amount))
            return dp.get(amount);

        int ans = -1;

        for (int coin : coins) {
            if (coin <= amount) {
                int value = getCoins(coins, amount - coin);

                if (value != -1 && (ans == -1 || value + 1 < ans))
                    ans = value + 1;
            }
        }

        dp.put(amount, ans);
        return ans;
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 1) {
            return (amount % coins[0] == 0) ? amount / coins[0] : -1;
        }

        return getCoins(coins, amount);
    }
}