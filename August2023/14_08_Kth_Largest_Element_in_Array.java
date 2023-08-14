// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Difficulty: Medium
// Time complexity: O(nlogk) where n is the length of the array and k is the input parameter
// Space complexity: O(k)

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);  // Add the current element to the min-heap
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest element if the size exceeds k
            }
        }

        return minHeap.peek();  // The root of the min-heap is the kth largest element
    }
}
