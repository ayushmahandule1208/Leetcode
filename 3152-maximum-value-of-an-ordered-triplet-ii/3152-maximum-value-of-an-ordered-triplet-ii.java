class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxVal = 0;
        int maxI = nums[0];          // Maximum nums[i] so far
        int maxDiff = 0;             // Maximum (nums[i] - nums[j]) so far
        
        for (int k = 2; k < nums.length; k++) {
            // Update maxDiff with nums[k-1] as potential nums[j]
            maxDiff = Math.max(maxDiff, maxI - nums[k-1]);
            // Update maxI with nums[k-1] as potential nums[i]
            maxI = Math.max(maxI, nums[k-1]);
            // Calculate current triplet value
            maxVal = Math.max(maxVal, (long)maxDiff * nums[k]);
        }
        
        return maxVal < 0 ? 0 : maxVal;
    }
}