// Link: https://leetcode.com/problems/fair-distribution-of-cookies/description/
// Difficulty: Medium
// Time complexity: O(k^N) where N is the number of cookies and k is the number of children
// Space complexity: O(k) where k is the number of children

class Solution {
    int ans; // Variable to store the minimum unfairness
    int count[]; // Array to keep track of the number of cookies assigned to each child
    
    public int distributeCookies(int[] cookies, int k) {
        ans = Integer.MAX_VALUE; // Initialize ans to the maximum possible integer value
        count = new int[k]; // Initialize the count array to keep track of assigned cookies for each child

        backtrack(0, cookies, k); // Call the backtrack function to explore all possible distributions
        
        return ans; // Return the minimum unfairness
    }
    
    public void backtrack(int cookieNumber, int[] cookies, int k) {
        if (cookieNumber == cookies.length) {
            int max = 0;
            
            // Calculate the maximum number of cookies assigned to any child in the current distribution
            for (int i = 0; i < k; i++) {
                max = Math.max(max, count[i]);
            }
            
            ans = Math.min(ans, max); // Update the minimum unfairness
            
            return; // Exit the current recursion
        }
        
        // Try assigning the current cookie to each child
        for (int i = 0; i < k; i++) {
            count[i] += cookies[cookieNumber]; // Assign the current cookie to child i
            
            backtrack(cookieNumber + 1, cookies, k); // Recursively move to the next cookie
            
            count[i] -= cookies[cookieNumber]; // Backtrack by removing the current cookie assignment
            
            if (count[i] == 0) {
                break; // Optimization: If a child has received no cookies, further distributions will be the same
            }
        }
    }
}
