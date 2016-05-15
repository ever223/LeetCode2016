package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 12:27.
 * @DESCRIPTION:
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, null, paths);
        return paths;
    }
    public void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (path == null) {
            path = "" + root.val;
        } else {
            path += "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, path, paths);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path, paths);
        }
    }
}
