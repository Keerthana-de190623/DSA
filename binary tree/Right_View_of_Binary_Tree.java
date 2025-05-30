

import java.util.ArrayList;
import java.util.List;



public class Right_View_of_Binary_Tree {
    

    private void right(Node node,int level,List<Integer> ans){
        if(node==null)return;
        if(level==ans.size())ans.add(node.data);
        if(node.right!=null)right(node.right,level+1,ans);
        if(node.left!=null)right(node.left,level+1,ans);
    }
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        right(root,0,ans);
        return ans;
    }
}