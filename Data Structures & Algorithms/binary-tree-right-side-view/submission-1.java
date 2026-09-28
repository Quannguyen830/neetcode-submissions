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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.addLast(root);

        while (!dq.isEmpty()) {
            int levelSize = dq.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = dq.pollFirst();
                if (node.left != null)
                    dq.addLast(node.left);
                if (node.right != null)
                    dq.addLast(node.right);

                if (i == levelSize - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
