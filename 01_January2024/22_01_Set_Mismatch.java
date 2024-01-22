// Link: https://leetcode.com/problems/set-mismatch/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long sumOfN = (long) n * (n + 1) / 2;
        long sumOfN2 = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSum2 = 0;

        for (int num : nums) {
            actualSum += num;
            actualSum2 += (long) num * num;
        }

        long diffSum = sumOfN - actualSum;
        long diffSum2 = sumOfN2 - actualSum2;

        long sumAandB = diffSum2 / diffSum;

        int repeatedNumber = (int) ((diffSum + sumAandB) / 2);
        int missingNumber = (int) (sumAandB - repeatedNumber);

        return new int[]{missingNumber, repeatedNumber};
    }
}
