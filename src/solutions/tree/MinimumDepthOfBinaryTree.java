package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 21:54.
 * @DESCRIPTION:
 */
public class MinimumDepthOfBinaryTree {
    // 遍历
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            int n = queue.size();
            depth ++;
            while((n --) != 0) {
                TreeNode node = queue.remove(0);
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null) {
            return 1;
        }  else if(root.left == null) {
            return minDepth(root.right) + 1;
        } else if(root.right == null ) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
