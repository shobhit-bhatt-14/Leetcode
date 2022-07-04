class Solution {
    public int maxProfit(int[] prices) {
        int profit=0, buy=prices[0];
        
        for(int i=1 ; i<prices.length ; i++) {
            int currentProfit = prices[i]-buy;
            if(currentProfit > profit)
                profit = currentProfit;
            
            buy = Math.min(prices[i], buy);
        }
        
        return profit;
    }
}