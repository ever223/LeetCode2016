package solutions.greedy;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 09:53.
 * @DESCRIPTION:
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int cur = nums.length - 2;
        while(cur >= 0) {
            if (target - cur <= nums[cur]) {
                target = cur;
            }
            cur --;
        }
        return target == 0;
    }
}
