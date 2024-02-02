// Link: https://leetcode.com/problems/sequential-digits/
// Difficulty: Medium
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String allDigits = "123456789";
        int n = allDigits.length();

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                String subStr = allDigits.substring(start, start + len);
                int num = Integer.parseInt(subStr);
                
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }
}
