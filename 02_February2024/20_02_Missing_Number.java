// Link: https://leetcode.com/problems/missing-number/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int num = nums.length;
        int actualSum = (num * (num + 1)) / 2;
        int calculatedSum = 0;
        for(int n : nums){
            calculatedSum += n;
        }

        return actualSum - calculatedSum;
    }
}