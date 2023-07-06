// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0; // Pointers i and j to track the subarray
        int sum=0; // Variable to store the sum of the current subarray
        int min=Integer.MAX_VALUE; // Variable to store the minimum length of subarray
        while(j<nums.length){ // Iterate through the array
            sum+=nums[j]; // Add the current element to the sum
            while(sum>=target){ // If the sum is greater than or equal to the target
                min=Math.min(min,j-i+1); // Update the minimum length of subarray
                sum-=nums[i]; // Subtract the first element of the subarray from the sum
                i++; // Move the left pointer to the right
            }
            j++; // Move the right pointer to the right
        }
        return min==Integer.MAX_VALUE?0:min; // Return the minimum length of subarray
    }
}
