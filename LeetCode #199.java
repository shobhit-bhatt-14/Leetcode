import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void preOrder(TreeNode node, List<Integer> ans, int index) {
        if (node != null) {
            if (index >= ans.size())
                ans.add(index, node.val);
            else
                ans.set(index, node.val);

            preOrder(node.left, ans, index + 1);
            preOrder(node.right, ans, index + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        preOrder(root, ans, 0);

        return ans;
    }
}