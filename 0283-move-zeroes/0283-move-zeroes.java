class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int zeroes = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
              zeroes++;
              continue;
            }
            temp.add(nums[i]);
        }
        int i = 0;
        while(i<temp.size()){
            nums[i] = temp.get(i);
            i++;
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}