package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-07 12:07.
 * @DESCRIPTION:
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows == 0) return triangle;
        List<Integer> pascals = new ArrayList<Integer>();
        for (int i = 1; i <= numRows; i++) {
            for (int j = pascals.size() - 1; j > 0; j --) {
                pascals.set(j, pascals.get(j - 1) + pascals.get(j));
            }
            pascals.add(1);
            triangle.add(new ArrayList<Integer>(pascals));
        }
        return triangle;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) {
            return triangle;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        triangle.add(row1);
        for(int i = 2; i <= numRows; i ++) {
            List<Integer> rowi = new ArrayList<>();
            List<Integer> rowi_1 = triangle.get(i - 2);
            int pre = 0;
            for(Integer num : rowi_1) {
                rowi.add(pre + num);
                pre = num;
            }
            rowi.add(1);
            triangle.add(rowi);
        }
        return triangle;
    }
}
