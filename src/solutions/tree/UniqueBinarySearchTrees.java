package solutions.tree;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-06 14:40.
 * @DESCRIPTION:
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] trees = new int[n + 1];
        Arrays.fill(trees, 0);
        trees[0] = 1;
        trees[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < n; j ++) {
                trees[i] += trees[j] * trees[i - j - 1];
            }
        }
        return trees[n];
    }
}
