// Link: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
// Difficulty: Medium
// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    // Function to perform garbage collection.
    public int garbageCollection(String[] garbage, int[] travel) {
      // Array to store the prefix sum of the travel array.
      int[] prefix = new int[travel.length];
      prefix[0] = travel[0];
  
      // Calculate the prefix sum of the travel array.
      for (int i = 1; i < prefix.length; ++i)
        prefix[i] += prefix[i - 1] + travel[i];
  
      // Calculate the time for each type of garbage collection.
      final int timeM = getTime(garbage, prefix, 'M');
      final int timeP = getTime(garbage, prefix, 'P');
      final int timeG = getTime(garbage, prefix, 'G');
  
      // Return the total time for garbage collection.
      return timeM + timeP + timeG;
    }
  
    // Function to calculate the time for a specific type of garbage collection.
    private int getTime(String[] garbage, int[] prefix, char c) {
      int characterCount = 0;
      int lastIndex = -1;
  
      // Iterate through the garbage array.
      for (int i = 0; i < garbage.length; ++i) {
        final String s = garbage[i];
        
        // Check if the current string contains the specified character 'c'.
        if (s.chars().anyMatch(g -> g == c))
          lastIndex = i;  // Update the lastIndex to the current index if 'c' is found.
  
        // Count the occurrences of 'c' in the current string.
        characterCount += (int) s.chars().filter(g -> g == c).count();
      }
  
      // Calculate the total time for garbage collection of type 'c'.
      // If lastIndex is less than or equal to 0, then there is no previous index, so return 0.
      // Otherwise, return the prefix sum at the lastIndex - 1.
      return characterCount + (lastIndex <= 0 ? 0 : prefix[lastIndex - 1]);
    }
  }
  