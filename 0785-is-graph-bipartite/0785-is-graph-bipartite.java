class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                q.add(i);
                color[i] = 0;
            
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].length;j++){
                        int neigh = graph[curr][j];

                        if(color[neigh]==-1){
                            color[neigh] = 1 - color[curr];
                            q.add(neigh);
                        }
                        else if(color[neigh]==color[curr]){
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }
}
