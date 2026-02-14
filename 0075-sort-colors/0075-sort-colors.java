class Solution {
    public void sortColors(int[] nums) {
        int low=0, mid = 0;
        int high = nums.length-1;

        while(mid<=high){
          //1. case-1
          if(nums[mid] == 0){
             swap(nums,mid,low);
             mid++;
             low++;
          }
          //2. case-2
          else if(nums[mid] == 1){
            mid++;
          }
          //3. case-3
          else{
            swap(nums,mid,high);
            high--;  
          }
        }
    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}