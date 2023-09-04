// Link: https://leetcode.com/problems/linked-list-cycle/
// Difficulty: Easy
// Time complexity: O(n) where n is the number of nodes in the linked list
// Space complexity: O(1) because we only use two pointers

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, there can't be a cycle.
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move the slow pointer one step
            fast = fast.next.next;    // Move the fast pointer two steps
            
            if (slow == fast) {
                return true; // If they meet, there is a cycle.
            }
        }
        
        return false; // If fast reaches the end of the list, there is no cycle.
    }
}
