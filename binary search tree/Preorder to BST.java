class Solution {
    Node *make_bst(int *pre, int size, int &index, int min, int max){
        if(index>= size){
            return nullptr;
        }
        if(min>pre[index] or max< pre[index])
        return nullptr;
        Node* root= newNode(pre[index++]);
        root->left= make_bst(pre, size, index, min, root->data);
        root->right= make_bst(pre, size, index, root->data, max);
        return root;
    }
  public:
    // Function that constructs BST from its preorder traversal.
    Node* Bst(int pre[], int size) {
       int index= 0;
     return  make_bst(pre, size, index, INT_MIN, INT_MAX);
       
    }
};