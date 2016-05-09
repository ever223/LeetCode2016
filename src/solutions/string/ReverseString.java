package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-09 17:11.
 * @DESCRIPTION:
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()- 1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
