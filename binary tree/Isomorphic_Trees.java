
public class Isomorphic_Trees {
    
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;//dono me se koi ek null h 
        if(root1.data != root2.data) return false;
        
        return (isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right))||(isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left));
    }
}