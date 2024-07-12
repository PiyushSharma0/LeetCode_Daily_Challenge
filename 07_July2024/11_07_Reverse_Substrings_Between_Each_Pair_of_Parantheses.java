// Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] index_pairs = new int[n];
        Deque<Integer> stack_start_ind = new LinkedList<>();

        for (int char_ind = 0; char_ind < n; ++char_ind) {
            char char_s = s.charAt(char_ind);
            if (char_s == '(') {
                stack_start_ind.push(char_ind);
            } else if (char_s == ')') {
                int start_ind = stack_start_ind.pop();
                index_pairs[char_ind] = start_ind;
                index_pairs[start_ind] = char_ind;
            }
        }

        StringBuilder res = new StringBuilder();
        int cur_ind = 0;
        int cur_dir = 1;

        while (cur_ind < n) {
            char char_s = s.charAt(cur_ind);
            if (char_s == '(' || char_s == ')') {
                cur_ind = index_pairs[cur_ind];
                cur_dir *= -1;
            } else {
                res.append(char_s);
            }
            cur_ind += cur_dir;
        }

        return res.toString();
    }
}
