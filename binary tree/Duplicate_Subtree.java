
import java.util.HashSet;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class Duplicate_Subtree {

    HashSet<String> hs=new HashSet<>();
    int dupSub(Node root) {
        if(solve(root).equals("#"))
            return 1;
        else
            return 0;
    }
    public String solve(Node root)
    {
        String s="";
        if(root==null)
            return "$";
        String ls=solve(root.left);
        if(ls.equals("#"))
            return "#";
        String rs=solve(root.right);
        if(rs.equals("#"))
            return "#";
        s=root.data+"/"+ls+"_"+rs;
        String r=Integer.toString(root.data);
        if(s.length()>r.length()+4 && hs.contains(s))
            return "#";
        hs.add(s);
        return s;
    }
}