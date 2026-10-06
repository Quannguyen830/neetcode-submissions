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
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i=0; i<levelSize; i++) {
                TreeNode cur = queue.poll();

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }

                if (cur.right != null) {
                    queue.addLast(cur.right);
                }

                if (i == levelSize-1) {
                    result.add(cur.val);
                }
            }
        }

        return result;
    }
}
