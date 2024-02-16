// Link: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
// Difficulty: Medium
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Count occurrences of each integer
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a priority queue to store integers based on their frequencies
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        // Add unique integers to the priority queue
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
        }

        // Remove the least frequent integers until k elements are removed
        while (k > 0 && !minHeap.isEmpty()) {
            int num = minHeap.poll();
            int frequency = frequencyMap.get(num);
            if (k >= frequency) {
                k -= frequency;
            } else {
                minHeap.offer(num);
                break;
            }
        }

        // The remaining size of the priority queue is the least number of unique integers
        return minHeap.size();
    }
}
