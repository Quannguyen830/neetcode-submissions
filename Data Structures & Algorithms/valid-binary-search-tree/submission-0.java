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
        if (root == null) return true;
        boolean leftC = root.left != null ? root.left.val < root.val : true;
        boolean rightC = root.right != null ? root.right.val > root.val : true;

        return isValidBST(root.left) && isValidBST(root.right) && leftC && rightC;
    }
}
