package solutions.stack;

import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 19:59.
 * @DESCRIPTION:
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String operations = "+-*/";
        for (String token : tokens) {
            if (operations.contains(token)) {
                op(stack, token);
            }else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    public void op(Stack<Integer> stack, String operation) {
        Integer num1 = stack.pop();
        Integer num2 = stack.pop();
        switch (operation) {
            case "+":
                stack.add(num1 + num2);
                break;
            case "-":
                stack.add(num2 - num1);
                break;
            case "*":
                stack.add(num1 * num2);
                break;
            default:
                stack.add(num2 / num1);
                break;
        }
    }
}
