package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 19:29.
 * @DESCRIPTION:
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        int maxPosition = 0;
        int maxLength = Integer.MAX_VALUE;
        for (String str : strs) {
            maxLength = Math.min(maxLength, str.length());
        }
        for (int i = 0; i < maxLength; i ++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            maxPosition = i;
        }
        return strs[0].substring(0, maxPosition + 1);
    }
}
