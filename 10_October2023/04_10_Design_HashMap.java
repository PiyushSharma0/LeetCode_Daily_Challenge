// Link: https://leetcode.com/problems/design-hashmap/
// Difficulty: Easy
// Time complexity: O(1)
// Space complexity: O(n)

import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap {
    // Define the capacity of the HashMap (number of buckets)
    private static final int CAPACITY = 1000;

    // Array of linked lists to store key-value pairs
    private LinkedList<Entry>[] buckets;

    // Constructor to initialize the HashMap
    public MyHashMap() {
        // Initialize the array with the specified capacity
        buckets = new LinkedList[CAPACITY];
        
        // Initialize each bucket with an empty linked list
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Method to insert or update a (key, value) pair in the HashMap
    public void put(int key, int value) {
        // Calculate the index of the bucket using the key
        int index = getIndex(key);
        
        // Get the linked list at the calculated index
        LinkedList<Entry> bucket = buckets[index];
        
        // Iterate through the linked list to check if the key already exists
        for (Entry entry : bucket) {
            if (entry.key == key) {
                // If the key exists, update the corresponding value
                entry.value = value;
                return;
            }
        }
        
        // If the key does not exist, add a new entry to the linked list
        bucket.add(new Entry(key, value));
    }

    // Method to retrieve the value associated with a key
    public int get(int key) {
        // Calculate the index of the bucket using the key
        int index = getIndex(key);
        
        // Get the linked list at the calculated index
        LinkedList<Entry> bucket = buckets[index];
        
        // Iterate through the linked list to find the key
        for (Entry entry : bucket) {
            if (entry.key == key) {
                // If the key is found, return the corresponding value
                return entry.value;
            }
        }
        
        // If the key is not found, return -1
        return -1;
    }

    // Method to remove a (key, value) pair from the HashMap
    public void remove(int key) {
        // Calculate the index of the bucket using the key
        int index = getIndex(key);
        
        // Get the linked list at the calculated index
        LinkedList<Entry> bucket = buckets[index];
        
        // Use an iterator to safely remove the entry with the specified key
        Iterator<Entry> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    // Helper method to calculate the index of the bucket using the key
    private int getIndex(int key) {
        return key % CAPACITY;
    }

    // Nested class to represent an entry (key, value) pair
    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
