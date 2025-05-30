class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        if(root == null)
            return 0;
        if(h < root.data)
            return getCount(root.left, l , h);
        else if(h == root.data)
            return 1+countGreater(root.left, l);
        else if(l > root.data)
            return getCount(root.right, l , h);
        else if(l == root.data)
            return 1+countLesser(root.right, h);
        else
            {
                // l< root < h
                int left = countGreater(root.left, l);
                int right = countLesser(root.right, h);
                
                return left+right+1;
            }
        
    }
    
    int countGreater(Node node, int l){
        if(node == null)
            return 0;
        
        if(node.data >= l)
            return 1+countGreater(node.left,l)+ countGreater(node.right , l);
        else 
            return countGreater(node.right , l);
    }
    
    int countLesser(Node node, int h){
        if(node == null)
            return 0;
        
        if(node.data <= h)
            return 1+countLesser(node.left,h)+ countLesser(node.right , h);
        else 
            return countLesser(node.left,h);
    }
    
}