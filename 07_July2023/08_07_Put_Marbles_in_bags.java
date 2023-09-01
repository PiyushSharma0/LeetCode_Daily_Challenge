// Link: https://leetcode.com/problems/put-marbles-in-bags/
// Difficulty: Hard but I think it's Medium
// Time complexity: O(nlogn)
// Space complexity: O(n)

import java.util.Arrays;

class Solution {
  public long putMarbles(int[] weights, int k) {
    // To distribute marbles into k bags, there will be k - 1 cuts. If there's a
    // cut after weights[i], then weights[i] and weights[i + 1] will be added to
    // the cost. Also, no matter how we cut, weights[0] and weights[n - 1] will
    // be counted. So, the goal is to find the max/min k - 1 weights[i] +
    // weights[i + 1].

    // Create an array to store weights[i] + weights[i + 1]
    int[] A = new int[weights.length - 1];

    // Initialize variables for minimum and maximum cost
    long min = 0;
    long max = 0;

    // Calculate weights[i] + weights[i + 1] and store them in array A
    for (int i = 0; i < A.length; ++i)
      A[i] = weights[i] + weights[i + 1];

    // Sort array A in ascending order
    Arrays.sort(A);

    // Calculate minimum and maximum cost by summing up k - 1 smallest and largest elements in array A
    for (int i = 0; i < k - 1; ++i) {
      min += A[i];
      max += A[A.length - 1 - i];
    }

    // Return the difference between the maximum and minimum cost
    return max - min;
  }
}
