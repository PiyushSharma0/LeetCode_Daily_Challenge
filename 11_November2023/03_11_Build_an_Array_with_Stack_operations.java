// Link: https://leetcode.com/problems/build-an-array-with-stack-operations/description/
// Difficulty: Medium but easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        // Create a list to store the operations.
        List<String> operations = new ArrayList<>();
        
        // Initialize the current index to track the target array.
        int currentIndex = 0;
        
        // Loop from 1 to 'n' and stop when currentIndex reaches the end of the target array.
        for (int i = 1; i <= n && currentIndex < target.length; i++) {
            // If the current value in 'i' matches the target element at currentIndex.
            if (i == target[currentIndex]) {
                operations.add("Push"); // Add "Push" operation to the list.
                currentIndex++; // Move to the next element in the target array.
            } else {
                // If there is a mismatch, push the current value 'i' and then pop it.
                operations.add("Push"); // Add "Push" operation to the list.
                operations.add("Pop");  // Add "Pop" operation to the list.
            }
        }
        
        // Return the list of operations.
        return operations;
    }
}
