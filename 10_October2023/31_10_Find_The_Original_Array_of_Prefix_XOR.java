// Link: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = pref[i]; // First element is the same as pref[0]
            } else {
                arr[i] = pref[i] ^ pref[i - 1]; // XOR with the previous element in pref
            }
        }
        
        return arr;
    }
}