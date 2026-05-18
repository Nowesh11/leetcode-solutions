class Solution {
    class Pair {
        TreeNode node;
        TreeNode parent;

        Pair(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, null));

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode parentX = null;
            TreeNode parentY = null;

            for (int i = 0; i < size; i++) {

                Pair curr = queue.poll();

                if (curr.node.val == x) parentX = curr.parent;
                if (curr.node.val == y) parentY = curr.parent;

                if (curr.node.left != null)
                    queue.offer(new Pair(curr.node.left, curr.node));

                if (curr.node.right != null)
                    queue.offer(new Pair(curr.node.right, curr.node));
            }

            if (parentX != null && parentY != null) {
                return parentX != parentY; // same parent → false
            }

            if (parentX != null || parentY != null) {
                return false;
            }
        }

        return false;
    }
}