

public class Balanced_Tree_Check {

    private int height(Node root){
        if(root==null)return 0;
        int l=height(root.left);
        int r=height(root.right);
        if(l==-1 || r==-1)return -1;
        if(Math.abs(l-r)>1)return -1;
        return Math.max(l,r)+1;
    }
    
    public boolean isBalanced(Node root) {
        return height(root)!=-1;
    }
}
