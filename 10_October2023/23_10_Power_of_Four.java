// Link: https://leetcode.com/problems/power-of-four/
// Difficulty: Easy
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0)
        return false;
        if(n==1)
        return true;
        if (n%4==0){
            return isPowerOfFour(n/4);
        }
        else 
            return false;
    }
}