class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            int index = -1;

            // Find the index of num in nums2
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == num) {
                    index = i;
                    break;
                }
            }

            // Look for the next greater element to the right
            int nextGreater = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > num) {
                    nextGreater = nums2[j];
                    break;
                }
            }

            result.add(nextGreater);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
