package solutions.stack;

import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-14 12:13.
 * @DESCRIPTION:
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stack = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.add(stack.pop());
        }
        stack.add(x);
        while (!temp.isEmpty()) {
            stack.add(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
