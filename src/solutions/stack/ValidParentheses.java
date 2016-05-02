package solutions.stack;

import java.util.List;
import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 21:07.
 * @DESCRIPTION:
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((c == '}' && stack.peek() == '{')
                        || (c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
        System.out.println(isValid("(}})"));

    }
}
