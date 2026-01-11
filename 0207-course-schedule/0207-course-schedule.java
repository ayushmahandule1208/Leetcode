class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(!vis[i]){
                if(detectCycle(prerequisites, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycle(int[][] prerequisites,boolean[] vis, int curr, int par){
        vis[curr] = true;
        for(int i=0;i<prerequisites[curr].length;i++){
            int neigh = prerequisites[curr][i];

            if(vis[neigh] && neigh != par){
                return true;
            }

            else if(!vis[neigh]){
              if(detectCycle(prerequisites, vis, neigh, curr)){
                return true;
              }
            }
        }
        return false;
    }
}