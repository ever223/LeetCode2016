package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-16 20:37.
 * @DESCRIPTION:
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
