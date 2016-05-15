package solutions.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-14 14:38.
 * @DESCRIPTION:
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> queue = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            temp.add(temp.poll());
        }
        queue.add(x);
        while (!temp.isEmpty()) {
            queue.add(temp.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
