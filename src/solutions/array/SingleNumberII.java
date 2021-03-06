package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-16 20:43.
 * @DESCRIPTION:
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int positive = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                positive ++;
            }
            for (int j = 0; j < count.length && num != 0; j++) {
                count[j] += num & 1;
                num >>= 1;
            }
        }
        int single = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (positive % 3 == 1) {
                count[i] = count[i] % 3 + 3;
            }
            single = single * 2 + count[i] % 3;
        }
        return single;
    }
    public int singleNumber2(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < count.length && (num >> j) != 0; j++) {
                count[j] += (num >> j) & 1;
            }
        }
        int single = 0;
        for (int i = 0; i < 32; i++) {
            single |= (count[i] % 3) << i;
        }
        return single;
    }

    public int singleNumber1(int[] nums) {
        int len = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }

}
