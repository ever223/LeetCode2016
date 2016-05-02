package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 20:31.
 * @DESCRIPTION:
 */
public class CountAndSay {
    public String countAndSay(int n) {
        //String[] mapping = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String say = "1";
        for (int i = 1; i < n; i++) {
            say = countAndSay(say);
        }
        return say;
    }
    public String countAndSay(String num) {
        String say = "";
        int count = 1;
        int pre = num.charAt(0) - '0';
        for (int i = 1; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (pre != n) {
                say += count + "" + pre;
                pre = n;
                count = 0;
            }
            count ++;
        }
        say += count + "" + pre;
        return say;
    }
}
