// Link: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        int[] min4 = new int[4];
        int[] max4 = new int[4];

        Arrays.fill(min4, Integer.MAX_VALUE);
        Arrays.fill(max4, Integer.MIN_VALUE);

        for (int num : nums) {
            boolean added = false;
            for (int j = 0; j < min4.length; j++) {
                if (num < min4[j]) {
                    shift(min4, j);
                    min4[j] = num;
                    added = true;
                    break;
                }
            }
            if (!added && min4[min4.length - 1] == Integer.MAX_VALUE) {
                min4[min4.length - 1] = num;
            }
        }

        for (int num : nums) {
            boolean added = false;
            for (int j = 0; j < max4.length; j++) {
                if (num > max4[j]) {
                    shift(max4, j);
                    max4[j] = num;
                    added = true;
                    break;
                }
            }
            if (!added && max4[max4.length - 1] == Integer.MIN_VALUE) {
                max4[max4.length - 1] = num;
            }
        }

        int ans = max4[0] - min4[0];
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, max4[3 - i] - min4[i]);
        }
        return ans;
    }

    private void shift(int[] a, int start) {
        int last = a[a.length - 1];
        for (int j = a.length - 1; j > start; j--) {
            a[j] = a[j - 1];
        }
        if (a.length < 4) {
            a[a.length - 1] = last;
        }
    }
}