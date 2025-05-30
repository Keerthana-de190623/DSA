

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class ZigZag_Tree_Traversal {
    

    ArrayList<Integer> zigZag_Traversal(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                if(flag)ans.add(node.data);
                else level.add(0,node.data);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
                   
            }
            ans.addAll(level);
            flag=!flag;
        }
        return ans;
    }
}


