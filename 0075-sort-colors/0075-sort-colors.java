class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        // Count 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0) zeroes++;
            else if (num == 1) ones++;
            else twos++;
        }

        // Place 0s
        int index = 0;
        for (int i = 0; i < zeroes; i++) {
            nums[index++] = 0;
        }
        // Place 1s
        for (int i = 0; i < ones; i++) {
            nums[index++] = 1;
        }
        // Place 2s
        for (int i = 0; i < twos; i++) {
            nums[index++] = 2;
        }
    }
}
