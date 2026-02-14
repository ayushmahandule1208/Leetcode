class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int i, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;

        while(!q.isEmpty()){
            int curr = q.remove();

            for(int neigh:graph[curr]){
                if(color[neigh]==-1){
                    color[neigh] = 1-color[curr];
                    q.add(neigh);
                }
                else if(color[neigh]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}