class Solution {

    Integer[][] dp;
    int totalSum;

    public int lastStoneWeightII(int[] stones) {
        totalSum = 0;
        for (int s : stones) totalSum += s;

        // dp[index][diff + totalSum]
        dp = new Integer[stones.length][2 * totalSum + 1];

        return helper(stones, 0, 0);
    }

    private int helper(int[] stones, int index, int diff) {

        // Base case
        if (index == stones.length) {
            return Math.abs(diff);
        }

        // Memo check
        if (dp[index][diff + totalSum] != null) {
            return dp[index][diff + totalSum];
        }

        // Choices
        int add = helper(stones, index + 1, diff + stones[index]);
        int subtract = helper(stones, index + 1, diff - stones[index]);

        // Store and return
        return dp[index][diff + totalSum] = Math.min(add, subtract);
    }
}
