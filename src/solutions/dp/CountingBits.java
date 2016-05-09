package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-09 17:23.
 * @DESCRIPTION:
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        int base = 1;
        for (int i = 1; i <= num; i++) {
            if (i == base) {
                count[i] = 1;
                base *= 2;
            } else {
                count[i] = count[i - base / 2] + 1;
            }
        }
        return count;
    }
}
