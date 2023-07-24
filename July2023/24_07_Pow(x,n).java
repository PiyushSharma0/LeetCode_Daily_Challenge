// Link: https://leetcode.com/problems/powx-n/
// Difficulty: Medium (but I think it's easy)
// Time complexity: O(log n)
// Space complexity: O(log n) (because of the recursion stack)

class Solution {
    public double myPow(double x, int n) {
        // Check if n is negative
        if (n < 0) {
            // Handle the special case where n is the minimum integer value
            if (n == Integer.MIN_VALUE) {
                return (1.0 / x) * myPow(1.0 / x, -(n + 1));
            }
            // For other negative n, compute the reciprocal of x and make n positive
            return myPow(1.0 / x, -n);
        }
        // For non-negative n, delegate the calculation to the pow function
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        // Base case: x^0 = 1
        if (n == 0) {
            return 1;
        }

        // If n is even, compute the result of x^(n/2) and square it
        if (n % 2 == 0) {
            double halfPow = pow(x, n / 2);
            return halfPow * halfPow;
        }
        // If n is odd, compute the result of x^((n-1)/2), square it, and multiply by x
        else {
            double halfPow = pow(x, (n - 1) / 2);
            return x * halfPow * halfPow;
        }
    }
}