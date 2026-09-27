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
        Deque<TreeNode> dq = new ArrayDeque<>();

        result.add(new ArrayList<>(Arrays.asList(root.val)));
        dq.addLast(root);

        while (!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<levelSize; i++) {
                TreeNode node = dq.pollFirst();
                if (node.left != null) {
                    dq.addLast(node.left);
                    list.add(node.left.val);
                }

                if (node.right != null) {
                    dq.addLast(node.right);
                    list.add(node.right.val);
                }
            }

            if (!list.isEmpty()) {
                result.add(list);
            }
        }

        return result;
    }
}
