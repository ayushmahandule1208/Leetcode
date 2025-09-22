import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int elem = -1;
        int total = 0;
        for (int freq:hm.values()) {
            if (freq > max) {
                max = freq;
            }
        }

        for(int freq:hm.values()){
            if(freq==max){
                total+=freq;
            }
        }

        return total;
    }
}
