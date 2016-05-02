package solutions.greedy;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 10:48.
 * @DESCRIPTION:
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 1;
        int cur = 0;
        while (cur + nums[cur] < nums.length - 1) {
            int temp = cur;
            for (int i = cur + 1; i <= cur + nums[cur]; i ++) {
                if (nums[i] + i > temp + nums[temp]) {
                    temp = i;
                }
            }
            step ++;
            cur = temp;
        }
        return step;
    }
}
