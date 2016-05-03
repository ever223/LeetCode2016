package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 10:54.
 * @DESCRIPTION:
 */
public class ClimbingStairs {
    //Time Limit Exceeded
    public int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int one = climbStairs1(n - 1);
        int two = climbStairs1(n - 2);
        return one + two;
    }
    //ClimbingStairs(n) = ClimbingStairs(n - 2) + ClimbingStairs(n - 1)
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i ++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }

}
