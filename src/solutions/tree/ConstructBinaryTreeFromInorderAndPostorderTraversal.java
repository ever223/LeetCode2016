package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 16:49.
 * @DESCRIPTION:
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length,
                         postorder, 0, postorder.length);
    }
    public TreeNode buildTree(int[] inorder, int iStart, int iEnd,
                              int[] postorder, int pStart, int pEnd) {
        if (iStart == iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd - 1]);
        int posOfRootInInorder = iStart;
        while(posOfRootInInorder < iEnd && inorder[posOfRootInInorder] != postorder[pEnd - 1]) {
            posOfRootInInorder ++;
        }
        root.left = buildTree(inorder, iStart, posOfRootInInorder,
                              postorder, pStart, pStart + posOfRootInInorder - iStart);
        root.right = buildTree(inorder, posOfRootInInorder + 1, iEnd,
                               postorder,  pStart + posOfRootInInorder - iStart, pEnd - 1);
        return root;
    }
}
