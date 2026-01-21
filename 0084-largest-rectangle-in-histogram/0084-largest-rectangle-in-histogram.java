class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] nsr = new int[n];
        int[] nsl = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] = n;
            }
            else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        int max = 0;
        for(int i=0;i<n;i++){
            int width = nsr[i] - nsl[i] -1;
            int area = heights[i] * width;
            max = Math.max(max,area);
        }
        return max;
    }
}