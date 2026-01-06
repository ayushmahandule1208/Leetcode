class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int res = 0;
        for(int i=0;i<k;i++){
           res += cardPoints[i];
        }

        max = res;

        int l = k-1;
        int r = cardPoints.length-1;
        while(k!=0){
          res -= cardPoints[l];
          res += cardPoints[r];

          max  = Math.max(max, res);

          k--;
          l--;
          r--;
        }
        return max;
    }
}