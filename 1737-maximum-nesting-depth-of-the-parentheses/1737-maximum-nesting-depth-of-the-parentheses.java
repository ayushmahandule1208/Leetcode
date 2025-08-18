class Solution {
    public int maxDepth(String s) {
        int maxCnt = 0;
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
                maxCnt = Math.max(maxCnt, st.size());
            } else if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            }
        }
        
        return maxCnt;
    }
}
