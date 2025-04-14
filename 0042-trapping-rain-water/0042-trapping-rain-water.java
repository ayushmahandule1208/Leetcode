class Solution {
    public int trap(int[] height) {
        
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];


        prefix[0] = height[0];
        for(int i=1;i<prefix.length;i++){
          prefix[i] = Math.max(prefix[i-1],height[i]);
        }
        suffix[suffix.length-1] = height[suffix.length-1];
        for(int i=suffix.length-2;i>=0;i--){
          suffix[i] = Math.max(suffix[i+1],height[i]);
        }
        int total =0;
        for(int i =0;i<height.length;i++){
            int leftMax = prefix[i];
            int rightMax = suffix[i];
            if(height[i]<leftMax && height[i]<rightMax){
              total+= Math.min(leftMax,rightMax)-height[i];
            }
        }
        return total;
    }
}