package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 16:48.
 * @DESCRIPTION:
 */
public class ConstructBinaTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bulidTree(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }
    public TreeNode bulidTree(int[] preorder, int pStart, int pEnd,
                              int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int i = iStart;
        for (; i < iEnd; i ++) {
            if (inorder[i] == preorder[pStart]) {
                break;
            }
        }
        root.left = bulidTree(preorder, pStart + 1, pStart + 1 + i - iStart,
                inorder, iStart, i);
        root.right = bulidTree(preorder, pStart + 1 + i - iStart, pEnd,
                inorder, i + 1, iEnd);
        return root;
    }
}
