package solutions.dp;

import java.util.List;
import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 19:36.
 * @DESCRIPTION:
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int cumLeft = 0;
        int longest = 0;
        int curLen = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                cumLeft ++;
            } else {
                if (cumLeft == 0) {
                    curLen = 0;
                } else {
                    cumLeft --;
                    curLen ++;
                    longest = Math.max(curLen, longest);
                }
            }
        }
        return longest * 2;
    }
}
