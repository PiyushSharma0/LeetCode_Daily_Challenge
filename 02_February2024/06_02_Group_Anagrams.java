// Link: https://leetcode.com/problems/group-anagrams/
// Difficulty: Medium
// Time Complexity: O(n * k) where n is the length of the input array and k is the average length of the strings
// Space Complexity: O(n * k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a HashMap to store groups of anagrams
        HashMap<String, List<String>> keyToAnagrams = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Count the frequency of each character in the string
            int[] charCount = new int[26]; // Assuming lowercase English letters
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Convert the character count array to a string to use as a key
            String key = Arrays.toString(charCount);

            // Add the original string to the corresponding anagram group
            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Convert the values of the map to a list of lists
        List<List<String>> result = new ArrayList<>(keyToAnagrams.values());

        return result;
    }
}
