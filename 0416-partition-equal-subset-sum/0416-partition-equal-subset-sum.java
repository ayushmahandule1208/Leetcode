class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(nums, 0, sum / 2, dp);
    }

    private boolean helper(int[] nums, int index, int target, int[][] dp) {


        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean pick = helper(nums, index + 1, target - nums[index], dp);
        boolean notPick = helper(nums, index + 1, target, dp);

        dp[index][target] = (pick || notPick) ? 1 : 0;

        return pick || notPick;
    }
}
