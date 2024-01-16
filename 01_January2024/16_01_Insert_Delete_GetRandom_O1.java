// Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
// Difficulty: Medium
// Time complexity: O(1) for all operations (insert, remove, getRandom)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Value already exists
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Value not found
        }

        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap the element to remove with the last element
        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove);

        // Remove the last element (constant time)
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
