// Link: https://leetcode.com/problems/add-two-numbers-ii/
// Difficulty: Medium
// Time complexity: O(m + n) where m and n are the lengths of l1 and l2
// Space complexity: O(m + n) where m and n are the lengths of l1 and l2

import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Create two stacks to reverse the order of digits in l1 and l2
    Deque<ListNode> stack1 = new ArrayDeque<>();
    Deque<ListNode> stack2 = new ArrayDeque<>();

    // Push each node of l1 into stack1, reversing the order of digits
    while (l1 != null) {
      stack1.push(l1);
      l1 = l1.next;
    }

    // Push each node of l2 into stack2, reversing the order of digits
    while (l2 != null) {
      stack2.push(l2);
      l2 = l2.next;
    }

    // Initialize head to null and carry to 0 for the final sum linked list
    ListNode head = null;
    int carry = 0;

    // While there is a carry or there are still digits in stack1 or stack2
    while (carry > 0 || !stack1.isEmpty() || !stack2.isEmpty()) {
      // Add the carry value and the top values of stack1 and stack2
      if (!stack1.isEmpty())
        carry += stack1.pop().val;
      if (!stack2.isEmpty())
        carry += stack2.pop().val;

      // Create a new node for the sum digit and update head
      ListNode node = new ListNode(carry % 10);
      node.next = head;
      head = node;

      // Update carry for the next iteration
      carry /= 10;
    }

    // Return the final sum linked list
    return head;
  }
}
