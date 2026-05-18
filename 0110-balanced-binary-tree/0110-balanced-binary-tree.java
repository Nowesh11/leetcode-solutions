class Solution {

    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }

    public int findHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        if (left == -1) return -1;

        int right = findHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}