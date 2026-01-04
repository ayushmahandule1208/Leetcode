class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node prev = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                prev = null;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return root;
    }
}
