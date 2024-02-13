// Link: https://leetcode.com/problems/palindromic-substrings/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            ans += extendPalindromes(s, i, i);
            ans += extendPalindromes(s, i, i + 1);
        }

        return ans;
    }

    private int extendPalindromes(final String s, int l, int r) {
        int count = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            ++count;
            --l;
            ++r;
        }

        return count;
    }
}