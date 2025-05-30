class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        helper(root,res);
        return res.get(0);
    }
    void helper(Node root,ArrayList<Integer> res){
        if(root==null){
            return;
        }
        helper(root.left,res);
        res.add(root.data);
        helper(root.right,res);
    }
}