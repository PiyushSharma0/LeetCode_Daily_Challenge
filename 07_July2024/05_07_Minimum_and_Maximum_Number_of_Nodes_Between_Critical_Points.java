// Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
// Difficulty: Medium
// Time Complexity: O(N)
// Space Complexity: O(1)

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;

        int first_index = -1;
        int last_index = -1;

        int index = 1;

        int prev_index = -1;

        int min_dist = Integer.MAX_VALUE;

        while (curr.next != null) {

            if (prev.val > curr.val && curr.val < curr.next.val || prev.val < curr.val && curr.val > curr.next.val) {

                if (prev_index == -1) {
                    first_index = index;
                    prev_index = index;
                } else {
                    if (min_dist > index - prev_index) {
                        min_dist = index - prev_index;
                    }

                    prev_index = index;
                }

            }

            index++;

            curr = curr.next;
            prev = prev.next;

        }

        last_index = prev_index;

        int max_dist = -1;

        if (min_dist == Integer.MAX_VALUE) {
            int[] arr = { -1, -1 };
            return arr;
        } else {
            max_dist = last_index - first_index;
            int[] arr = { min_dist, max_dist };
            return arr;
        }

    }
}