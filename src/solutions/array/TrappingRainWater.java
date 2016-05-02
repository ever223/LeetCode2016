package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 12:31.
 * @DESCRIPTION:
 */
public class TrappingRainWater {
    public int trap(int[] height) {

        int sum = 0;
        int highest = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[highest]) {
                highest = i;
            }
        }

        int left = 0;
        for (int i = 0; i < highest; i++) {
            if (height[i] > left) {
                left = height[i];
            } else {
                sum += left - height[i];
            }
        }

        int right = 0;
        for (int i = height.length - 1; i > highest; i--) {
            if (height[i] > right) {
                right = height[i];
            } else {
                sum += right - height[i];
            }
        }

        return sum;
    }
}
