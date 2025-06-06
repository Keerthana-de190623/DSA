
public class Height_of_Binary_Tree {
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
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null) return -1;
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int max = 1+Math.max(lh,rh);
        return max;
    }
}