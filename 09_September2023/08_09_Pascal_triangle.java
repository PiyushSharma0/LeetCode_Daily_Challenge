// Link: https://leetcode.com/problems/pascals-triangle/
// Difficulty: Easy
// Time complexity: O(n^2)
// Space complexity: O(n^2)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // The first element of each row is 1
            row.add(1);

            if (i > 0) {
                List<Integer> prevRow = triangle.get(i - 1);
                
                for (int j = 1; j < i; j++) {
                    // Calculate the current element by summing the two elements above it
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(value);
                }
                
                // The last element of each row is 1
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }
}
