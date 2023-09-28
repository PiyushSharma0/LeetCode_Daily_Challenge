// Link: https://leetcode.com/problems/sort-array-by-parity/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // Move the left pointer to the right while pointing to an even number
            if(nums[left] % 2 == 0) {
                left++;
            }
            
            // Move the right pointer to the left while pointing to an odd number
            else if (nums[right] % 2 != 0) {
                right--;
            }
            
            // Swap the even and odd elements
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        return nums;
    }
}
