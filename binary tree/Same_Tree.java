
public class Same_Tree {
    public class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
       this.right = right;
     }
  }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both trees are empty, they are identical.
        if (p == null && q == null) {
            return true;
        }
        // If one of the trees is empty and the other is not, they are not identical.
        if (p == null || q == null) {
            return false;
        }
        
        // Compare the values of the current nodes.
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check the left and right subtrees.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }    
}