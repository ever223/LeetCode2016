package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-07 20:20.
 * @DESCRIPTION:
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cursor = root;
        while(cursor != null) {
            if(cursor.left != null) {
                TreeNode pre = cursor.left;
                while(pre.right !=null) {
                    pre = pre.right;
                }
                pre.right = cursor.right;
                cursor.right = cursor.left;
                cursor.left= null;
            }
            cursor = cursor.right;
        }
    }
}
