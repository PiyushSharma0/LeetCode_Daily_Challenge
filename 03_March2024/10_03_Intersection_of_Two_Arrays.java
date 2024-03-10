// Link: https://leetcode.com/problems/intersection-of-two-arrays/
// Difficulty: Easy
// Time Complexity: O(n + m)
// Space Complexity: O(n + m)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        final int N = 1001;
        var set = new int [N];
        for (var i : nums1) set[i] = 1;
        int resCount = 0;
        for (var i : nums2) {
            if (set[i] == 1) {
                set[i] = 2;
                ++resCount;
            }
        }
        var res = new int[resCount];
        var i = 0;
        var nums = nums2.length > nums1.length ? nums1 : nums2;
        for (var v : nums) {
            if (set[v] == 2) {
                res[i++] = v;
                set[v] = 1;
            }
        }
        return res;
    }
    public int[] intersectionOnSet(int[] nums1, int[] nums2) {
       var  s1 = new HashSet<Integer>(nums1.length);
       for (var i : nums1) s1.add(i);
       var s2 = new HashSet<Integer>(nums2.length);
       for (var i : nums2) {
           if (s1.contains(i)) s2.add(i);
       }
       var res = new int[s2.size()];
       int j = 0;
       for (var i : s2){
            res[j++] = i;
       }
       return res;
    }
}