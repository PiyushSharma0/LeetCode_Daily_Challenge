// Link: https://leetcode.com/problems/number-of-flowers-in-full-bloom/
// Difficulty: Hard
// Time complexity: O(nlogn)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
      int[] ans = new int[persons.length];
      List<Integer> starts = new ArrayList<>();
      List<Integer> ends = new ArrayList<>();
  
      // Extract the start and end times of the flowers
      for (int[] flower : flowers) {
        starts.add(flower[0]);
        ends.add(flower[1]);
      }
  
      // Sort the start and end times
      Collections.sort(starts);
      Collections.sort(ends);
  
      for (int i = 0; i < persons.length; ++i) {
        // Find the first index of a start time greater than the person's arrival time
        final int started = firstGreater(starts, persons[i]);
        // Find the first index of an end time greater than or equal to the person's arrival time
        final int ended = firstGreaterEqual(ends, persons[i]);
        // Calculate the number of active flowers at the person's arrival time
        ans[i] = started - ended;
      }
  
      return ans;
    }
  
    // Finds the first index l s.t A.get(l) > target.
    // Returns A.size() if can't find.
    private int firstGreater(List<Integer> A, int target) {
      int l = 0;
      int r = A.size();
      while (l < r) {
        final int m = (l + r) / 2;
        if (A.get(m) > target)
          r = m;
        else
          l = m + 1;
      }
      return l;
    }
  
    // Find the first index l s.t A.get(l) >= target
    // Returns A.size() if can't find
    private int firstGreaterEqual(List<Integer> A, int target) {
      int l = 0;
      int r = A.size();
      while (l < r) {
        final int m = (l + r) / 2;
        if (A.get(m) >= target)
          r = m;
        else
          l = m + 1;
      }
      return l;
    }
  }
  