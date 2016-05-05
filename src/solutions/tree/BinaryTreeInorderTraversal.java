package solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 09:34.
 * @DESCRIPTION:
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node= root;
        while(node != null) {
            while(node.left != null) {
                stack.add(node);
                node = node.left;
            }
            inorder.add(node.val);
            if (node.right == null) {
                node = null;
                while (!stack.isEmpty() && node == null) {
                    node = stack.pop();
                    inorder.add(node.val);
                    node = node.right;
                }
                if (stack.isEmpty() && node == null) {
                    break;
                }
            } else {
                node = node.right;
            }
        }
        return inorder;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node= root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }

}
