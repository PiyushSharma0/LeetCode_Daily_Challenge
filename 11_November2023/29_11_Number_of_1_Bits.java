// Link: https://leetcode.com/problems/number-of-1-bits/
// Difficulty: Easy
// Time complexity: O(1)
// Space complexity: O(1)

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        // Loop through each bit of the integer
        for (int i = 0; i < 32; i++) {
            // Check if the current bit is set (equals 1)
            if ((n & 1) == 1) {
                count++;
            }
            
            // Right shift to check the next bit
            n >>= 1;
        }
        
        return count;
    }
}
