package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-06 09:50.
 * @DESCRIPTION:
 */
public class PopulatingNextRightPointersInEachNode {

    // 层次遍历法
    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            int n = queue.size();
            while((n --) != 0) {
                TreeLinkNode node = queue.remove(0);
                if(n != 0) {
                    node.next = queue.get(0);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }
    public void connect(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }
        root.next = next;
        if (next == null) {
            connect(root.right, null);
        } else {
            connect(root.right, next.left);
        }
    }
}
