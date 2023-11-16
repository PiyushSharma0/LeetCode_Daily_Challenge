// Link: https://leetcode.com/problems/find-unique-binary-string/
// Difficulty: Medium
// Time complexity: O(2^n)
// Space complexity: O(2^n)

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();

        // Add all binary strings from nums to the set
        for (String num : nums) {
            set.add(num);
        }

        // Iterate through all possible binary strings of length n
        for (int i = 0; i < (1 << n); i++) {
            String binaryString = Integer.toBinaryString(i);
            // Pad the binary string with leading zeros if needed
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }

            // Check if the binary string is not in the set
            if (!set.contains(binaryString)) {
                return binaryString;
            }
        }

        // This should not be reached since there is guaranteed to be a solution
        return "";
    }
}
