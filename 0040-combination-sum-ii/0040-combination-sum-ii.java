class Solution {

    public void findCombinations(
        int idx,
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        List<Integer> ds
    ) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // skip duplicates at same recursion level
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // no need to proceed further
            if (candidates[i] > target) break;

            // choose
            ds.add(candidates[i]);

            // explore (i + 1 → each element used once)
            findCombinations(i + 1, candidates, target - candidates[i], ans, ds);

            // un-choose
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // VERY IMPORTANT
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
