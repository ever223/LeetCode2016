package solutions.stack;

import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-09 16:38.
 * @DESCRIPTION:
 */
public class BasicCalculator {
    public final static String nonDigit = " )+-*/";
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = -1;
        for(Character c : s.toCharArray()) {
            if(nonDigit.indexOf(c) != -1 && num != -1) {
                nums.add(num);
                num = -1;
            }
            if (c == '(') {
                ops.add(c);
            } else if (nonDigit.indexOf(c) > 1) {
                if(!ops.isEmpty() && ops.peek() != '(' && (c == '+' || c == '-')) {
                    nums.add(operate(nums.pop(), nums.pop(), ops.pop()));
                }
                ops.add(c);
            } else if (c ==')'){
                Character op = ops.pop();
                while ( op != '(') {
                    nums.add(operate(nums.pop(), nums.pop(), op));
                    op = ops.pop();
                }
            } else if(c >= '0' && c <= '9'){
                if (num == -1) {
                    num = 0;
                }
                num = num * 10 + c - '0';
            }
        }
        if (num != -1) {
            nums.add(num);
        }
        while (!ops.isEmpty()) {
            nums.add(operate(nums.pop(), nums.pop(), ops.pop()));
        }
        return nums.pop();
    }
    private Integer operate(int num1, int num2, Character op) {
        switch (op) {
            case '+': return num1 + num2;
            case '-': return num2 - num1;
            case '*': return num1 * num2;
            default: return num2 / num1;
        }
    }
}
