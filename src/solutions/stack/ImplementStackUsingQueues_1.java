package solutions.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 11:04.
 * @DESCRIPTION:
 */
public class ImplementStackUsingQueues_1 {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        if (q2.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                Integer temp = q1.poll();
                if (q1.isEmpty()) {
                    return;
                }
                q2.add(temp);
            }
        } else {
            while (!q2.isEmpty()) {
                Integer temp = q2.poll();
                if (q2.isEmpty()) {
                    return;
                }
                q1.add(temp);
            }
        }
    }

    // Get the top element.
    public int top() {
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                Integer temp = q1.poll();
                q2.add(temp);
                if (q1.isEmpty()) {
                    return temp;
                }
            }
        } else {
            while (!q2.isEmpty()) {
                Integer temp = q2.poll();
                q1.add(temp);
                if (q2.isEmpty()) {
                    return temp;
                }
            }
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
