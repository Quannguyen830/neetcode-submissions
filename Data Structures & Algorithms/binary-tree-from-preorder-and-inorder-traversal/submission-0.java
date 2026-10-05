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
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length-1, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = map.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = helper(preorder, preStart+1, preStart+leftSize, inStart, inRoot-1);
        root.right = helper(preorder, preStart+leftSize+1, preEnd, inRoot+1, inEnd);

        return root;
    }
}
