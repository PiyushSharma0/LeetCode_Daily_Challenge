// Link: https://leetcode.com/problems/smallest-sufficient-team/
// Difficulty: Hard
// Time complexity: O(p * 2^n) where p is the number of people and n is the number of skills
// Space complexity: O(2^n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        final int n = req_skills.length;
        final int nSkills = 1 << n;
        Map<String, Integer> skillToId = new HashMap();
        // dp[i] := min people's indices to cover skillset of mask i
        List<Integer>[] dp = new List[nSkills];
        dp[0] = new ArrayList<>();

        // Map each skill to its corresponding index for faster access.
        for (int i = 0; i < req_skills.length; ++i)
            skillToId.put(req_skills[i], i);

        // Iterate through each person and update the dp array.
        for (int i = 0; i < people.size(); ++i) {
            final int currSkill = getSkill(people.get(i), skillToId);
            for (int j = 0; j < nSkills; ++j) {
                if (dp[j] == null)
                    continue;
                final int newSkillSet = currSkill | j;
                if (newSkillSet == j) // Adding people[i] doesn't increase skill set
                    continue;
                if (dp[newSkillSet] == null || dp[newSkillSet].size() > dp[j].size() + 1) {
                    dp[newSkillSet] = new ArrayList<>(dp[j]);
                    dp[newSkillSet].add(i);
                }
            }
        }

        // Convert the list of people's indices to an array and return it.
        return dp[nSkills - 1].stream().mapToInt(Integer::intValue).toArray();
    }

    // Helper method to convert a person's skills into a bitmask representation.
    private int getSkill(List<String> person, Map<String, Integer> skillToId) {
        int mask = 0;
        for (final String skill : person) {
            if (skillToId.containsKey(skill)) {
                mask |= 1 << skillToId.get(skill);
            }
        }
        return mask;
    }
}
