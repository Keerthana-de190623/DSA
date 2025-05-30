
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    Node node;
    int line;
    Pair(Node node,int line){
        this.node=node;
        this.line=line;
    }
}
public class Top_View_of_Binary_Tree {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            Node node=it.node;
            int line=it.line;
            if(!map.containsKey(line))map.put(line,node.data);
            if(node.left!=null)q.add(new Pair(node.left,line-1));
            if(node.right!=null)q.add(new Pair(node.right,line+1));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())ans.add(entry.getValue());
        return ans;
    }
}
