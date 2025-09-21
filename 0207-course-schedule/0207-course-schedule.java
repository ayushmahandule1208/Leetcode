class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree =  new int[numCourses];

        for(int[] pre: prerequisites){
            int course2 = pre[0];
            int course1 = pre[1];

            graph.get(course1).add(course2);
            indegree[course2]++;
        }

        return !hasCycle(graph,indegree,numCourses);
    }

    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph,int[] indegree, int numCourses){
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            cnt++;

            for(int ne: graph.get(course)){
                indegree[ne]--;
                if(indegree[ne]==0){
                    q.add(ne);
                }
            }
        }
        if(cnt==numCourses){
            return false;
        }
        else{
            return true;
        }
    }
}