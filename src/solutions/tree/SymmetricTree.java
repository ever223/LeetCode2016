package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 14:55.
 * @DESCRIPTION:
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return (root != null) && isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> leftList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<TreeNode>();
        leftList.add(root.left);
        rightList.add(root.right);
        while (leftList.size() != 0) {
            int n = leftList.size();
            while(n != 0) {
                n --;
                TreeNode left = leftList.remove(0);
                TreeNode right = rightList.remove(rightList.size() - 1);

                if (left == null && right == null) {
                    continue;
                }
                if(left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                leftList.add(left.left);
                leftList.add(left.right);
                rightList.add(0, right.right);
                rightList.add(0, right.left);
            }
        }
        return true;
    }
}
