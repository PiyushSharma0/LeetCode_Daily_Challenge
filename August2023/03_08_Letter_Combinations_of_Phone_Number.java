import java.util.*;

class Solution {
    // Mapping of digits to letters
    private static final String[] letterMap = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Check for edge cases
        if (digits == null || digits.length() == 0) {
            return result; // Return an empty list if no digits are provided
        }
        
        // Start the backtracking process
        backtrack(result, new StringBuilder(), digits, 0);
        return result; // Return the list of letter combinations
    }
    
    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: If we have processed all digits, add the current combination to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the current digit and its corresponding letters
        char digit = digits.charAt(index);
        String letters = letterMap[digit - '0'];
        
        // Try each letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Append the letter to the current combination
            // Recurse for the next digit
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last letter
        }
    }
}
