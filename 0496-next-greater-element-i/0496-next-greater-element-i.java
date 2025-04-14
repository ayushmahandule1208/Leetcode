class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] res = new int[nums1.length];
      Stack<Integer> st = new Stack<>();
      HashMap<Integer,Integer> hm = new HashMap<>();

      for(int num:nums2){
        while(!st.isEmpty() && num>st.peek()){
            hm.put(st.pop(),num);
        }
        st.push(num);
      }
      int i=0;
      for(int num:nums1){
        res[i++] = hm.getOrDefault(num,-1);

      }
      return res;
    }
}
