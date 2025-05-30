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
    long Prev = Long.MIN_VALUE;

    void inorder(TreeNode a, boolean[] Is) {
        if (a == null){
            return;
        }
        inorder(a.left, Is);
        if (a.val <= Prev){
            Is[0] = false;
        }
        Prev = a.val;
        inorder(a.right, Is);
    }

    public boolean isValidBST(TreeNode a) {
        boolean[] Is = {true};
        inorder(a, Is);
        return Is[0];
    }
}