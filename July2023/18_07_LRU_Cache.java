// Link: https://leetcode.com/problems/lru-cache/
// Difficulty: Medium
// Time complexity: O(1) for both get and put
// Space complexity: O(capacity) where capacity is the capacity of the cache

import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // Move the accessed node to the front (most recently used position)
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // Move the updated node to the front (most recently used position)
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() >= capacity) {
                // Evict the least recently used key (tail's prev node)
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }
}
