class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buyPrice = prices[0];
        for(int i=0;i<prices.length;i++){
          int profit = 0;
          if(prices[i]<buyPrice){
            buyPrice = prices[i];
          }
          profit = prices[i] - buyPrice;
          maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}