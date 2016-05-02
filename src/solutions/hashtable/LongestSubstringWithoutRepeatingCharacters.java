package solutions.hashtable;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-29 10:59.
 * @DESCRIPTION:
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return longest;
        }
        int[] positions = new int[256];
        Arrays.fill(positions, -1);
        int start = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            longest = Math.max(longest, i - start + 1);
            if (positions[c] == -1 || positions[c] < start) {
                longest = Math.max(longest, i - start + 1);
            } else {
                start = positions[c] + 1;
            }
            positions[c] = i;
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcc"));
        System.out.println(lengthOfLongestSubstring("abc"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
