// Link: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

public boolean canMakeArithmeticProgression(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
        min = Math.min(min, num);
        max = Math.max(max, num);
        set.add(num);
    }

    int n = arr.length;
    int diff = (max - min) / (n - 1);

    if ((max - min) % (n - 1) != 0) {
        return false;
    }

    for (int i = 0; i < n; i++) {
        if (!set.contains(min + i * diff)) {
            return false;
        }
    }

    return true;
}