// Link: https://leetcode.com/problems/implement-queue-using-stacks/
// Difficulty: Easy
// Time complexity: O(1) for push, O(n) for pop
// Space complexity: O(n)

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            transferElements();
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            transferElements();
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transferElements() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
