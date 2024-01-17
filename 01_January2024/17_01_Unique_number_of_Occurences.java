// Link: https://leetcode.com/problems/unique-number-of-occurrences/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> occurences = new HashSet<>();

        for(final int a: arr){
            freq.merge(a,1,Integer::sum);
        }

        for(final int value : freq.values()){
            if(!occurences.add(value)){
                return false;
            }
        }
        return true;
    }
}