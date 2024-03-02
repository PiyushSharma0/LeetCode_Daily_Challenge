// Link: https://leetcode.com/problems/squares-of-a-sorted-array/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] *= nums[i];
        }

        int i = n-1;
        int left = 0, right = n-1;
        while(left <= right){
            if(nums[left] > nums[right]){
                ans[i--] = nums[left++];
            } else {
                ans[i--] = nums[right--];
            }
        }
        return ans;
    }
}