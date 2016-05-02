package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 10:15.
 * @DESCRIPTION:
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] <= height[right]) {
                left ++;
            } else {
                right -- ;
            }
        }
        return max;
    }
}
