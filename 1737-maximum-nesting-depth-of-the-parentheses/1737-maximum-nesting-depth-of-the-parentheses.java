class Solution {
    public int maxDepth(String s) {
        int maxCnt = 0;
        int cnt = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                cnt++;
                maxCnt = Math.max(cnt,maxCnt);
            }
            else if(arr[i]==')'){
                cnt--;
            }
        }
        return maxCnt;
    }
}
