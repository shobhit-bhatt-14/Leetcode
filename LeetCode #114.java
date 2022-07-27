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
    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;

            root.left = null;

            flatten(tempLeft);
            flatten(tempRight);

            root.right = tempLeft;

            TreeNode last = root;
            while (last.right != null)
                last = last.right;

            last.right = tempRight;
        }
    }
}