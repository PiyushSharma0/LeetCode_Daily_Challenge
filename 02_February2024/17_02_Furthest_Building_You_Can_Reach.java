// Link: https://leetcode.com/problems/furthest-building-you-can-reach/
// Difficulty: Medium
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                minHeap.offer(diff);
                
                // If the number of ladders is not enough, use bricks instead
                if (minHeap.size() > ladders) {
                    bricks -= minHeap.poll();
                }

                // If bricks become negative, return the current index
                if (bricks < 0) {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}
