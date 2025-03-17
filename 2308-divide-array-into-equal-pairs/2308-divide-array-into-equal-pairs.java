import java.util.Arrays;

class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) return false; // Odd length can't be divided into pairs
        
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length; i += 2) {
            // Check if adjacent elements are equal
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        return true; // If all pairs are equal
    }
}
