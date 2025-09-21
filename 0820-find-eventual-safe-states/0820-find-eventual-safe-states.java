class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            g.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j: graph[i]){
                g.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
               q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int ne : g.get(node)){
                indegree[ne]--;
                if(indegree[ne]==0){
                    q.add(ne);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}