package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 11:28.
 * @DESCRIPTION:
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        if (root == null) {
            return order;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            int n = list.size();
            List<Integer> level = new ArrayList<>();
            while (n != 0) {
                TreeNode node = list.remove(0);
                level.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                n --;
            }
        }
        return order;
    }
}
