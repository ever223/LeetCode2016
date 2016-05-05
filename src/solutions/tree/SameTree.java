package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 14:54.
 * @DESCRIPTION:
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        return p == null && q == null
                || !(p == null || q == null) && (p.val == q.val) && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
