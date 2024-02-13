// Link: https://leetcode.com/problems/largest-divisible-subset/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int currentLen = maxLen;
        int currentIndex = maxIndex;

        for (int i = maxIndex; i >= 0; i--) {
            if (nums[currentIndex] % nums[i] == 0 && dp[i] == currentLen) {
                result.add(nums[i]);
                currentLen--;
                currentIndex = i;
            }
        }

        return result;
    }
}
