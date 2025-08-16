class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
      int n = nums.length;
      for(int i=0;i<n;i++){
        pq.add(nums[i]);
      }
      int i = k-1;
      while(i>0){
        pq.remove();
        i--;
      }
      return pq.peek();
    }
}