package solutions.backtracing;

import java.util.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 20:05.
 * @DESCRIPTION:
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        letterCombinations(digits, "", result, mapping);
        return result;

    }
    private void letterCombinations(String digits, String curStr, List<String> result, String[] mapping) {
        if (digits.length() == 0) {
            if (!curStr.equals("")) {
                result.add(curStr);
            }
            return;
        }
        int num = digits.charAt(0) - '0';
        if (num < 2) {
            letterCombinations(digits.substring(1), curStr, result, mapping);
        } else {
            for (int i = 0; i < mapping[num].length(); i ++) {
                letterCombinations(digits.substring(1), curStr + mapping[num].substring(i, i + 1), result, mapping);
            }
        }
    }
}
