// Link: https://leetcode.com/problems/find-the-town-judge/description/
// Difficulty: Easy
// Time Complexity: O(N) where N is the number of trust relationships
// Space Complexity: O(N)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            // Decrement out-degree for the person trusting
            outDegrees[a]--;

            // Increment in-degree for the person being trusted
            inDegrees[b]++;
        }

        for (int i = 1; i <= n; i++) {
            // Check if in-degree is (n-1) and out-degree is 0
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i; // i is the label of the town judge
            }
        }

        return -1; // No town judge found
    }
}
