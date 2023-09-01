// Link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
// Difficulty: Medium
// Time complexity: O(nlogn)
// Space complexity: O(n)

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public long totalCost(int[] costs, int k, int candidates) {
    long ans = 0;
    int i = 0;
    int j = costs.length - 1;
    Queue<Integer> minHeapL = new PriorityQueue<>();
    Queue<Integer> minHeapR = new PriorityQueue<>();

    for (int hired = 0; hired < k; ++hired) {
      while (minHeapL.size() < candidates && i <= j)
        minHeapL.offer(costs[i++]); // Add costs from the left side to minHeapL
      while (minHeapR.size() < candidates && i <= j)
        minHeapR.offer(costs[j--]); // Add costs from the right side to minHeapR

      if (minHeapL.isEmpty())
        ans += minHeapR.poll(); // If minHeapL is empty, select the minimum cost from minHeapR
      else if (minHeapR.isEmpty())
        ans += minHeapL.poll(); // If minHeapR is empty, select the minimum cost from minHeapL
      // Both `minHeapL` and `minHeapR` are not empty.
      else if (minHeapL.peek() <= minHeapR.peek())
        ans += minHeapL.poll(); // Select the minimum cost from minHeapL
      else
        ans += minHeapR.poll(); // Select the minimum cost from minHeapR
    }

    return ans;
  }
}
