import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsr = new int[n]; 
        int[] nsl = new int[n]; 

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();


        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && heights[s1.peek()] >= heights[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s1.peek();
            }
            s1.push(i);
        }

    
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && heights[s2.peek()] >= heights[i]) {
                s2.pop();
            }
            if (s2.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s2.peek();
            }
            s2.push(i);
        }


        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
