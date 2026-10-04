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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);

            for (int i=0; i<levelSize; i++) {
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }

                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}