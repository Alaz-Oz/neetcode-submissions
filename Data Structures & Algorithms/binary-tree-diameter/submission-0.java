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
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return result;
    }
    
    int result = 0;

    public int dia(TreeNode root){
        // Return deepest length
        if (root == null) return 0;
        int left = dia(root.left);
        int right = dia(root.right);

        int sum = left + right;
        if (sum > result) result = sum;

        return Math.max(left, right) + 1;
    }
}
