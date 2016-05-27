package solutions.array;

import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 17:23.
 * @DESCRIPTION:
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                if (stack.peek() == num) {
                    stack.add(num);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.pop();
    }
}
