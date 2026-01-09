class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int src = 0;
        int dest = graph.length - 1;

        dfs(graph, src, dest, path, res);
        return res;
    }

    private void dfs(int[][] graph, int src, int dest,
                     List<Integer> path, List<List<Integer>> res) {

        path.add(src);

        if (src == dest) {
            res.add(new ArrayList<>(path)); // important copy
        } else {
            for (int neigh : graph[src]) {
                dfs(graph, neigh, dest, path, res);
            }
        }

        path.remove(path.size() - 1); // backtrack
    }
}
