// Link: https://leetcode.com/problems/split-linked-list-in-parts/
// Difficulty: Medium
// Time complexity: O(n) where n is the number of nodes in the linked list
// Space complexity: O(1) because we don't use any extra space

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        
        // Calculate the length of the linked list
        while (current != null) {
            length++;
            current = current.next;
        }
        
        int baseSize = length / k; // Size of each part
        int extraNodes = length % k; // Number of extra nodes
        
        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            result[i] = current; // Start of the current part
            int partSize = baseSize + (extraNodes > 0 ? 1 : 0); // Calculate part size
            
            // Traverse the current part
            for (int j = 1; j < partSize; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            
            if (current != null) {
                ListNode next = current.next;
                current.next = null; // End the current part
                current = next;
            }
            
            if (extraNodes > 0) {
                extraNodes--;
            }
        }
        
        return result;
    }
}
