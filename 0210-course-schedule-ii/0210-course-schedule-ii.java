class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre: prerequisites){
           int course2 = pre[0];
           int course1 = pre[1];
           graph.get(course1).add(course2);
           indegree[course2]++;
        }
        
        ArrayList<Integer> topo1 = getArray(numCourses,graph,indegree);
        int[] res = new int[numCourses];
        for(int i=0;i<topo1.size();i++){
            res[i] = topo1.get(i);
        }
        if(topo1.size()==numCourses){
            return res;
        }
        return new int[]{};
    
    }

    public ArrayList<Integer> getArray(int numCourses,ArrayList<ArrayList<Integer>> graph, int[] indegree){
        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
           if(indegree[i]==0){
            q.add(i);
           }
        }

        while(!q.isEmpty()){
            int course = q.poll();
            topo.add(course);

            for(int ne:graph.get(course)){
                indegree[ne]--;
                if(indegree[ne]==0){
                    q.add(ne);
                }
            }
        }
        return topo;


    }
}