class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i =0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int i, boolean[] vis, int[][] isConnected){
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while(!q.isEmpty()){
            int neigh = q.poll();

            for(int j=0;j<n;j++){
                if(isConnected[neigh][j] == 1 && !vis[j]){
                    vis[j] = true;
                    q.offer(j);
                }
            }
        }

    }
}