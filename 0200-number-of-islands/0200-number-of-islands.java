class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int i, int j, int[][] vis, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        
        int[] dr = {-1, 0 , 1,0};
        int[] dc = {0, 1 , 0,-1};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int k=0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                    vis[nr][nc] =1;
                    q.offer(new int[]{nr,nc});

                }
            }
        }
    }
}