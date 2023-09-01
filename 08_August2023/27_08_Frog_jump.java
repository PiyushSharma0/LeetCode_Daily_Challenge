// Link: https://leetcode.com/problems/frog-jump/
// Difficulty: Hard (Tricky)
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        // Create a HashMap to store possible jump sizes for each stone position
        HashMap<Integer, HashSet<Integer>> jumpMap = new HashMap<>();
        
        // Initialize the jump possibilities for the first stone
        jumpMap.put(0, new HashSet<>());
        jumpMap.get(0).add(1);
        
        // Iterate through the stones and update jump possibilities
        for (int stone : stones) {
            if (!jumpMap.containsKey(stone)) {
                continue; // Skip stones without jump possibilities
            }
            
            HashSet<Integer> jumps = jumpMap.get(stone);
            for (int jumpSize : jumps) {
                int nextPosition = stone + jumpSize;
                if (nextPosition == stones[stones.length - 1]) {
                    return true; // Frog successfully crossed the river
                }
                
                // Update jump possibilities for the next stone
                if (jumpSize > 1) {
                    updateJumpMap(jumpMap, nextPosition, jumpSize - 1);
                }
                updateJumpMap(jumpMap, nextPosition, jumpSize);
                updateJumpMap(jumpMap, nextPosition, jumpSize + 1);
            }
        }
        
        return false; // Frog couldn't cross the river
    }
    
    // Helper function to update jump possibilities in the jumpMap
    private void updateJumpMap(HashMap<Integer, HashSet<Integer>> jumpMap, int position, int jumpSize) {
        if (jumpSize > 0) {
            jumpMap.computeIfAbsent(position, k -> new HashSet<>()).add(jumpSize);
        }
    }
}
