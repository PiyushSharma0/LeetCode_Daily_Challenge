// Link: https://leetcode.com/problems/implement-stack-using-queues/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Add the new element to queue1
        queue1.add(x);

        // Move elements back from queue2 to queue1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
