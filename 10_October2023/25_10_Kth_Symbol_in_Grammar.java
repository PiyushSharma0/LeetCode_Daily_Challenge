// Link: https://leetcode.com/problems/k-th-symbol-in-grammar/
// Difficulty: Medium
// Time complexity: O(n)
//  Space complexity: O(n)

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        // Recursively find the kth symbol in the (n-1)th row
        int prevKth = kthGrammar(n - 1, (k + 1) / 2);
        
        // If k is even, it corresponds to the second character in "01" or "10"
        // If k is odd, it corresponds to the first character in "01" or "10"
        if (k % 2 == 0) {
            return 1 - prevKth; // Invert the symbol if k is even
        } else {
            return prevKth;
        }
    }
}
