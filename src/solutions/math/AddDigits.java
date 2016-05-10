package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-09 19:15.
 * @DESCRIPTION:
 */
public class AddDigits {
    public int addDigits(int num) {
        while(num / 10 != 0) {
            int temp = 0;
            while(num != 0) {
                temp += (num % 10);
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}
