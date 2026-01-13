class Solution {

    int f(int i, int[] nums, int[] dp) {

        if (i < 0) return 0;
        if (i == 0) return nums[0];

        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.max(
            nums[i] + f(i - 2, nums, dp),
            f(i - 1, nums, dp)
        );
    }

    public int rob(int[] nums) {

        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        // Case 1: rob from 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = f(n - 2, nums, dp1);

        // Case 2: rob from 1 to n-1
        int[] arr = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = nums[i];
        }

        int[] dp2 = new int[n - 1];
        Arrays.fill(dp2, -1);
        int case2 = f(n - 2, arr, dp2);

        return Math.max(case1, case2);
    }
}
