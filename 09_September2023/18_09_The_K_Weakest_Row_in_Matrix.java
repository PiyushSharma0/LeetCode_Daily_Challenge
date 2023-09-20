// Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// Difficulty: Easy
// Time complexity: O(m * n * logk)
// Space complexity: O(k)

import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create a max heap (priority queue) to store rows based on their strength
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // Compare strengths in reverse order
            } else {
                return Integer.compare(b[1], a[1]); // Compare indices in reverse order
            }
        });
        
        for (int i = 0; i < m; ++i) {
            int strength = countOnes(mat[i]);
            maxHeap.offer(new int[] {strength, i});
            
            // If the heap size exceeds k, remove the row with the highest strength
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[] ans = new int[k];
        
        // Populate the result array with the k weakest row indices in reverse order
        for (int i = k - 1; i >= 0; --i) {
            ans[i] = maxHeap.poll()[1];
        }
        
        return ans;
    }
    
    // Helper function to count the number of ones in a row
    private int countOnes(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num == 1) {
                count++;
            }
        }
        return count;
    }
}