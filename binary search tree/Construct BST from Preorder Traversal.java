import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int val) {
        key = val;
        left = right = null;
    }
}

class GfG {

    // A Simple BST Insert
    public static Node insertBST(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (root.key > key)
            root.left = insertBST(root.left, key);
        else if (root.key < key)
            root.right = insertBST(root.right, key);
        return root;
    }

    // Constructs BST from the given Preorder Traversal
    public static Node construct(List<Integer> pre) {
        Node root = null;

        // One by one insert all keys from pre[]
        for (int key : pre) {
            root = insertBST(root, key);
        }

        return root;
    }

    // A function to print BST in inorder
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Driver code
    public static void main(String[] args) {
        List<Integer> pre = Arrays.asList(10, 5, 1, 7, 40, 50);
        Node root = construct(pre);
        inorder(root);
    }
}