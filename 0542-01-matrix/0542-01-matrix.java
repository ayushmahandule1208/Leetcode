class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        
        // initialize with -1 for cells we haven't visited
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0}); // start BFS from 0 cells
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            
            for(int[] dir: dirs){
                int x = r + dir[0];
                int y = c + dir[1];
                
                if(x>=0 && y>=0 && x<m && y<n && dist[x][y] == -1){
                    dist[x][y] = d+1;
                    q.add(new int[]{x, y, d+1});
                }
            }
        }
        
        return dist;
    }
}
