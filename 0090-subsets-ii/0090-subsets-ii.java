class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);        
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> temp) {
        // Add current subset
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {

            // Skip duplicates at same level
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Choose
            temp.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, temp);

            // Un-choose
            temp.remove(temp.size() - 1);
        }
    }
}
