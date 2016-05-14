package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-13 17:26.
 * @DESCRIPTION:
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length;
        while (left < right) {
            while (left < right && !isVowels(chars[left])) {
                left ++;
            }
            while (left < right && !isVowels(chars[right - 1])) {
                right --;
            }
            if (left < right) {
                Character temp = chars[left];
                chars[left] = chars[right - 1];
                chars[right - 1] = temp;
                left ++;
                right --;
            }
        }
        return new String(chars);
    }
    public boolean isVowels(Character c) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(c) != -1;
    }
}
