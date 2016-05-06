package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-06 13:43.
 * @DESCRIPTION:
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        return postorder;
    }
    public void postorderTraversal(TreeNode root, List<Integer> postorder) {
        if(root == null) {
            return;
        }
        postorderTraversal(root.left, postorder);
        postorderTraversal(root.right, postorder);
        postorder.add(root.val);
    }
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if(root == null) {
            return postorder;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            TreeNode node = queue.remove(queue.size() - 1);
            while(node != null) {
                postorder.add(0, node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                node = node.right;
            }
        }
        return postorder;
    }
}
