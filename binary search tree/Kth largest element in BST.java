
class Solution {
    public int kthLargest(Node root, int k) {
        int cnt=0;
        int res=-1;
        Node curr=root;
        while(curr!=null){
            if(curr.right==null){
                cnt++;
                if(cnt==k)res=curr.data;
                curr=curr.left;
            }
            else{
                Node prev=curr.right;
                while(prev.left!=null && prev.left!=curr)prev=prev.left;
                if(prev.left==null){
                    prev.left=curr;
                    curr=curr.right;
                }
                else{
                    prev.left=null;
                    cnt++;
                    if(cnt==k)res=curr.data;
                    curr=curr.left;
                }
            }
        }
        return res;
    }
}