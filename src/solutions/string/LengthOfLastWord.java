package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 19:01.
 * @DESCRIPTION:
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.length() == 0) {
            return length;
        }
        int pos = s.length() - 1;
        while ( pos >= 0 && s.charAt(pos) == ' ') {
            pos --;
        }
        if (pos < 0) {
            return length;
        }
        while(pos >= 0 && s.charAt(pos) != ' ') {
            length ++;
            pos --;
        }
        return length;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" a"));
    }
}
