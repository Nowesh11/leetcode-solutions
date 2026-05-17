class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        // both null
        if (left == null && right == null) {
            return true;
        }

        // one null
        if (left == null || right == null) {
            return false;
        }

        // values different
        if (left.val != right.val) {
            return false;
        }

        // compare mirror children
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}