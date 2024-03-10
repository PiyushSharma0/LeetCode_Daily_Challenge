// Link: https://leetcode.com/problems/count-elements-with-maximum-frequency/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxnum = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n > maxnum)
                maxnum = n;
        }
        
        int cnt[] = new int[maxnum + 1];
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            cnt[nums[i]]++;
            if(cnt[nums[i]] > max) max = max + 1; 
        }
        int ans = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == max){
                ans += cnt[i];
            }
        }
        return ans;
    }
}