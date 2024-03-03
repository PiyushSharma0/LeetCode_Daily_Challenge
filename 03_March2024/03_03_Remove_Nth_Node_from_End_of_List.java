// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode current = head;

        ListNode prev = dummy;
        ListNode next = current;
        for(int i=0;i<n-1;i++){
            if(next!=null){
                next = next.next;
            }
        }
        while(next.next!=null){
            prev = current;
            current = current.next;
            next = next.next;
        }
        if(prev!=null){
        prev.next = current.next;
        }
        return dummy.next;        
    }
}