package solutions.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 12:26.
 * @DESCRIPTION:
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generateParenthesis(n, 0, "", parenthesis);
        return parenthesis;
    }
    //left 表示剩余"("数量， right 表示已用"("的数量，也就是当前可用")"的数量
    public void generateParenthesis(int left, int right, String currentParenthesis, List<String> parenthesis) {
        if (left == 0 && right == 0) {
            if (!currentParenthesis.equals("")) {
                parenthesis.add(currentParenthesis);
            }
            return;
        }
        if (left != 0) {
            generateParenthesis(left - 1, right + 1, currentParenthesis + "(", parenthesis);
        }
        if(right != 0) {
            generateParenthesis(left, right - 1, currentParenthesis + ")", parenthesis);
        }
    }
}
