class Solution {
    public void helper(Node root,ArrayList<Node> ar){
        if(root==null) return;
        helper(root.left,ar);
        ar.add(root);
        helper(root.right,ar);
    }
    public void populateNext(Node root) {
        // code here
        ArrayList<Node> ar = new ArrayList<>();
        helper(root,ar);
        for(int i=0;i<ar.size()-1;i++){
            ar.get(i).next=ar.get(i+1);
        }
    }
}