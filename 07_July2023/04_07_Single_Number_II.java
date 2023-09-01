// Link: https://leetcode.com/problems/single-number-ii/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;  // Track the bits that appeared once
        int twos = 0;  // Track the bits that appeared twice
        
        for (int num : nums) {
            // Update 'twos' by OR-ing the bits that appeared in 'ones' and the current number
            twos |= ones & num;
            
            // Update 'ones' by XOR-ing the bits that appeared once with the current number
            ones ^= num;
            
            // Mask out the bits that appeared three times by AND-ing the complement of 'ones' and 'twos'
            int mask = ~(ones & twos);
            ones &= mask;
            twos &= mask;
        }
        
        return ones;
    }
}
