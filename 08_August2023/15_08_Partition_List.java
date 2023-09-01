// Link: https://leetcode.com/problems/partition-list/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessThanXHead = new ListNode(0); // Dummy node for the list with nodes less than x
        ListNode lessThanX = lessThanXHead;
        
        ListNode greaterEqualXHead = new ListNode(0); // Dummy node for the list with nodes greater than or equal to x
        ListNode greaterEqualX = greaterEqualXHead;
        
        ListNode current = head;
        
        while (current != null) {
            if (current.val < x) {
                lessThanX.next = current;
                lessThanX = lessThanX.next;
            } else {
                greaterEqualX.next = current;
                greaterEqualX = greaterEqualX.next;
            }
            current = current.next;
        }
        
        greaterEqualX.next = null; // Set the next of the last node to null to avoid cycles
        
        lessThanX.next = greaterEqualXHead.next; // Connect the two partitions
        
        return lessThanXHead.next;
    }
}
