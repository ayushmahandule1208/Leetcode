class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxRes = 0;
        int l = 0;
        int r = 0;
        int n  = nums.length;
        int zeroes = 0;

        while(r<n){
            if(nums[r]==0){
             zeroes++;
            }
            if(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                int len  = (r-l)+1;
                maxRes =  Math.max(maxRes,len);
            }
            r++;
        }
return maxRes;
      
    }
}