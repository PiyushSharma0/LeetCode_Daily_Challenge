// Link: https://leetcode.com/problems/sort-characters-by-frequency/
// Difficulty: Medium
// Time Complexity: O(n log n) where n is the length of the input string
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Create a map to store character frequencies
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Create a priority queue to sort characters based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charFrequencyMap.get(b) - charFrequencyMap.get(a));
        maxHeap.addAll(charFrequencyMap.keySet());
        
        // Build the sorted string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int frequency = charFrequencyMap.get(currentChar);
            
            // Append the character to the result string based on its frequency
            for (int i = 0; i < frequency; i++) {
                result.append(currentChar);
            }
        }
        
        return result.toString();
    }
}
