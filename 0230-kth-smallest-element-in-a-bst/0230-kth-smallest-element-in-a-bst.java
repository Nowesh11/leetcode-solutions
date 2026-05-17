class Solution {

    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        // left
        inorder(node.left, k);

        // root
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // right
        inorder(node.right, k);
    }
}