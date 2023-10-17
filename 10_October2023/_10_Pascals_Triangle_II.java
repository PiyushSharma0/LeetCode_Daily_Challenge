// Link: https://leetcode.com/problems/pascals-triangle-ii/
// Difficulty: Easy
// Time complexity: O(n^2)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            // Each row starts with 1
            row.add(1);

            // Calculate the values in between
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}