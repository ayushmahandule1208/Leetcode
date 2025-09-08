class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            time = Math.max(time, t);

            for(int[] d: dirs){
                int x  = r + d[0];
                int y = c + d[1];
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                    grid[x][y]=2;
                    fresh--;
                    q.add(new int[]{x,y,t+1});
                }
            }
        }
        if(fresh > 0){
         return -1;
        }
        else{
            return time;
        }

    }
}