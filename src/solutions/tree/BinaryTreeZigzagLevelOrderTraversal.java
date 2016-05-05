package solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 14:26.
 * @DESCRIPTION:
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> orders = new ArrayList<>();
        if (root == null) {
            return orders;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while (queue.size() != 0) {
            level ++;
            int size = queue.size();
            List<Integer> order = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.remove(0);
                if(level % 2 == 1) {
                    order.add(node.val);
                } else {
                    order.add(0, node.val);
                }
                if (node.right != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size --;
            }
            orders.add(order);
        }
        return orders;
    }
}
