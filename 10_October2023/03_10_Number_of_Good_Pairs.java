// Link: https://leetcode.com/problems/number-of-good-pairs/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        int goodPairsCount = 0;
        
        // Iterate through the array and update the frequency map
        for (int num : nums) {
            // If the number is already in the map, increment the count
            if (frequencyMap.containsKey(num)) {
                goodPairsCount += frequencyMap.get(num);
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                // If the number is not in the map, add it with a count of 1
                frequencyMap.put(num, 1);
            }
        }
        
        return goodPairsCount;
    }
}
