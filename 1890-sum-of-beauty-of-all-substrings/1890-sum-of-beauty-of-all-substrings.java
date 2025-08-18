class Solution {
    public int beautySum(String s) {
        int res = 0;

        // Fix starting point of substring
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> freq = new HashMap<>();

            // Expand substring ending at j
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0) + 1);

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // Find max and min frequencies from map
                for (int count : freq.values()) {
                    maxFreq = Math.max(maxFreq, count);
                    minFreq = Math.min(minFreq, count);
                }

                res += (maxFreq - minFreq);
            }
        }

        return res;
    }
}
