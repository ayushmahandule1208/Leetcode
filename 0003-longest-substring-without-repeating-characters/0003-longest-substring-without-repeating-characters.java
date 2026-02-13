class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        int n = s.length();

        for(int r=0;r<n;r++){

            if(hm.containsKey(s.charAt(r)) && hm.get(s.charAt(r))>=l){
                l = hm.get(s.charAt(r))+1;
            }

            hm.put(s.charAt(r),r);

            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}