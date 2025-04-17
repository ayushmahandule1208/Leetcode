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
    private int treeHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHt = treeHeight(root.left);
        int rightHt = treeHeight(root.right);
        return Math.max(leftHt,rightHt)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDiam = diameterOfBinaryTree(root.left);
        int rightDiam = diameterOfBinaryTree(root.right);
        int leftHt = treeHeight(root.left);
        int rightHt = treeHeight(root.right);
        int selfDiam = leftHt + rightHt;
        return Math.max(Math.max(leftDiam, rightDiam), selfDiam);

    }
}