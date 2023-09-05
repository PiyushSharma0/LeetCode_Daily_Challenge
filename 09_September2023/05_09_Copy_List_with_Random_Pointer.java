// Link: https://leetcode.com/problems/copy-list-with-random-pointer/
// Difficulty: Medium
// Time complexity: O(n) where n is the number of nodes in the linked list
// Space complexity: O(n) because we use a HashMap to map original nodes to new nodes

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Create a HashMap to map original nodes to their corresponding new nodes.
        Map<Node, Node> nodeMap = new HashMap<>();
        
        // First pass: Create new nodes and map original nodes to new nodes.
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }
        
        // Second pass: Set the next and random pointers for the new nodes.
        current = head;
        while (current != null) {
            Node newNode = nodeMap.get(current);
            newNode.next = nodeMap.get(current.next);
            newNode.random = nodeMap.get(current.random);
            current = current.next;
        }
        
        // Return the head of the new linked list.
        return nodeMap.get(head);
    }
}
