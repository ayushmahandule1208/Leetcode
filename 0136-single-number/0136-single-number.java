class Solution {
    public int singleNumber(int[] nums) {
        int num_xor = 0;
        for(int i=0;i<nums.length;i++){
           num_xor = num_xor ^ nums[i];
        }
        return num_xor;
    }
}