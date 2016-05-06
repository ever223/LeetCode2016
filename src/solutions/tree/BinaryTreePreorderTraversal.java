package solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-06 13:43.
 * @DESCRIPTION:
 */
public class BinaryTreePreorderTraversal {

    // 遍历版
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        return preorder;
    }
    public void preorderTraversal(TreeNode root, List<Integer> preorder) {
        if(root == null) {
            return;
        }
        preorder.add(root.val);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);
    }

    // 遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while(node != null) {
                preorder.add(node.val);
                if(node.right != null) {
                    stack.add(node.right);
                }
                node = node.left;
            }
        }
        return preorder;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
        return preorder;
    }
}
