

public class Leaves_at_Same_Level_or_Not {
    
    public void func(Node root,boolean[] res,int[] maxHeight,int height){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(maxHeight[0] == -1) maxHeight[0] = height; 
            if(maxHeight[0] != height) res[0] = false;
            return;
        }
        
        func(root.left,res,maxHeight,height+1);
        func(root.right,res,maxHeight,height+1);
        
    }
    boolean check(Node root) {
        // Your code here
        boolean[] res = new boolean[1];
        res[0] = true;
        int[] maxHeight = new int[1];
        maxHeight[0] = -1;
        func(root,res,maxHeight,0);
        return res[0];
    }
}

