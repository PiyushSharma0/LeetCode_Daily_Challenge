// Link: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
// Difficulty: Medium
// Time complexity: O(n) where n is the number of people
// Space complexity: O(n) where n is the number of people

import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        // Iterate through the groupSizes array
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // If the group size doesn't exist in the map, create a new group list
            if (!groupMap.containsKey(size)) {
                groupMap.put(size, new ArrayList<>());
            }

            // Add the person to the corresponding group
            List<Integer> group = groupMap.get(size);
            group.add(i);

            // If the group is complete, add it to the result and remove it from the map
            if (group.size() == size) {
                result.add(group);
                groupMap.remove(size);
            }
        }

        return result;
    }
}