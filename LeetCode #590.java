/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private void traversal(Node node, List ans) {
        if (node != null) {
            List<Node> childNodes = node.children;

            int len = childNodes.size();
            if (len == 0)
                ans.add(node.val);
            else {
                for (int i = 0; i < len; i++) {
                    traversal(childNodes.get(i), ans);
                }
                
                ans.add(node.val);
            }
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();

        traversal(root, ans);

        return ans;
    }
}