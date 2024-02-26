// Link: https://leetcode.com/problems/greatest-common-divisor-traversal/
// Difficulty: Hard
// Time Complexity: O(n * log(max(nums[i])))
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> primeFactorsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            List<Integer> primeFactors = getPrimeFactors(num);

            for (int factor : primeFactors) {
                primeFactorsMap.computeIfAbsent(factor, k -> new ArrayList<>()).add(i);
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (List<Integer> indices : primeFactorsMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
                union(parent, indices.get(i - 1), indices.get(i));
            }
        }

        int root = find(parent, 0);
        for (int i = 1; i < n; i++) {
            if (find(parent, i) != root) {
                return false;
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    private List<Integer> getPrimeFactors(int num) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            primeFactors.add(num);
        }
        return primeFactors;
    }
}
