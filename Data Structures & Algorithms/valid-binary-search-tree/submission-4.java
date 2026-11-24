/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        boolean leftC = root.left != null ? (root.left.val > min && root.left.val < root.val) : true;
        boolean rightC = root.right != null ? (root.right.val < max && root.right.val > root.val) : true;

        return leftC && rightC && validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}
