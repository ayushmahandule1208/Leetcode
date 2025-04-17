class Solution {
    private int maxDiameter = 0;

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // update max diameter at this node
        maxDiameter = Math.max(maxDiameter, left + right);

        // return height of current node
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }
}
