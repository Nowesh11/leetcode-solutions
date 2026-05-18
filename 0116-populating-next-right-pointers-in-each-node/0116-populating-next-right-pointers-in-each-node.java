class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node dummy = new Node();   // reset per level
            Node pointer = dummy;       // reset per level

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                pointer.next = curr;
                pointer = pointer.next;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            // end current level
            pointer.next = null;
        }

        return root;
    }
}