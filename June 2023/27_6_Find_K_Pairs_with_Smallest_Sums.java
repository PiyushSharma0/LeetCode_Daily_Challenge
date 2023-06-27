// Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
// Difficulty: Medium
// Time complexity: O(klogk) where k is the number of pairs
// Space complexity: O(k)

import java.util.*;

class Helper {
  public int i;
  public int j;
  public int sum; // nums1[i] + nums2[j]
  
  public Helper(int i, int j, int sum) {
    this.i = i;
    this.j = j;
    this.sum = sum;
  }
}

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> ans = new ArrayList<>(); // Stores the k smallest pairs
    Queue<Helper> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum); // Min-Heap to store Helpers based on their sum value
    
    // Consider the first k pairs with nums1[i] + nums2[0] and add them to the minHeap
    for (int i = 0; i < k && i < nums1.length; ++i)
      minHeap.offer(new Helper(i, 0, nums1[i] + nums2[0]));
    
    // Continue until either the minHeap is empty or we have k pairs in ans
    while (!minHeap.isEmpty() && ans.size() < k) {
      final int i = minHeap.peek().i; // Get the i index from the top Helper in minHeap
      final int j = minHeap.poll().j; // Get the j index from the top Helper and remove it from minHeap
      ans.add(Arrays.asList(nums1[i], nums2[j])); // Add the pair (nums1[i], nums2[j]) to ans
      
      // If there are more elements in nums2, add the next pair (nums1[i], nums2[j+1]) to minHeap
      if (j + 1 < nums2.length)
        minHeap.offer(new Helper(i, j + 1, nums1[i] + nums2[j + 1]));
    }
    
    return ans; // Return the k smallest pairs
  }
}
