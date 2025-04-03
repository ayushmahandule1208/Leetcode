class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        int cur = 1;

        // Compute prefix products
        for (int i = 0; i < n; i++) {
            prod[i] = cur;
            cur *= nums[i];
        }

        cur = 1;
        // Compute suffix products and multiply with prefix products
        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= cur;
            cur *= nums[i];
        }

        return prod;
    }
}