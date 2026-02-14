class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            int curr = prices[i];
            minPrice = Math.min(minPrice,curr);
            maxProfit = Math.max(maxProfit,curr-minPrice);
        }
        return maxProfit;
    }
}