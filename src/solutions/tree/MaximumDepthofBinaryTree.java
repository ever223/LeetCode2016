package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 16:34.
 * @DESCRIPTION:
 */
public class MaximumDepthofBinaryTree {
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 遍历
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while(queue.size() != 0) {
            int n = queue.size();
            level ++;
            while((n --) != 0) {
                TreeNode node = queue.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }
}
