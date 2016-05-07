package solutions.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-07 12:39.
 * @DESCRIPTION:
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> total = new ArrayList<>();
        total.add(0, 0);

        for (List<Integer> aTriangle : triangle) {
            total.add(Integer.MAX_VALUE);
            for (int j = aTriangle.size() - 1; j > 0; j--) {
                total.set(j, Math.min(total.get(j), total.get(j - 1)) + aTriangle.get(j));
            }
            total.set(0, total.get(0) + aTriangle.get(0));
        }
        int minTotal = Integer.MAX_VALUE;
        for(Integer val : total) {
            minTotal = Math.min(val, minTotal);
        }
        return minTotal;
    }
}
