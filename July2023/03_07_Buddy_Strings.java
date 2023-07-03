// Link: https://leetcode.com/problems/buddy-strings/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of the strings
// Space complexity: O(n) where n is the length of the strings

import java.util.*;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        // If the lengths of the strings are different, they cannot be buddy strings
        if (s.length() != goal.length())
            return false;
        
        // If the strings are equal, check if there are duplicate characters
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            // If there are duplicate characters, we can swap them to make the strings equal
            return set.size() < s.length();
        }
        
        // Find the indices where the characters differ between the two strings
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                list.add(i);
            }
        }
        
        // Check if there are exactly two differing indices and swapping them makes the strings equal
        return list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1)) && s.charAt(list.get(1)) == goal.charAt(list.get(0));
    }
}
