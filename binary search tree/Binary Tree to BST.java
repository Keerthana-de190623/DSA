class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    public Node helper1(ArrayList<Integer> ar,int start,int end){
       if(start>end) return null;
       int mid = (start+end)/2;
       Node root = new Node(ar.get(mid));
       root.left=helper1(ar,start,mid-1);
       root.right=helper1(ar,mid+1,end);
       return root;
    }
    public void helper(Node root,ArrayList<Integer> ar){
        if(root==null) return;
        helper(root.left,ar);
        ar.add(root.data);
        helper(root.right,ar);
    }
    Node binaryTreeToBST(Node root)
    {
       // Your code here
      ArrayList<Integer> ar = new ArrayList<>();
      helper(root,ar);
      Collections.sort(ar);
      return helper1(ar,0,ar.size()-1);
      
    }
}