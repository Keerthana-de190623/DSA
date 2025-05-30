// Java Program to find Size of Largest 
// BST in a Binary Tree

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class GfG {

    // Returns true if the given tree is
  	// BST, else false
    static boolean isValidBst(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data >= maxValue || root.data <= minValue) {
            return false;
        }
        return isValidBst(root.left, minValue, root.data) &&
               isValidBst(root.right, root.data, maxValue);
    }

    // Returns size of a tree
    static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Finds the size of the largest BST
    static int largestBst(Node root) {
      
        // If tree is empty
        if (root == null) {
            return 0;
        }

        // If whole tree is BST
        if (isValidBst
            (root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }

        // If whole tree is not BST
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

    public static void main(String[] args) {
      
      	
        // Constructed binary tree looks like this:
        //         50
        //       /    \
        //     75      45
        //    /
        //  40

        Node root = new Node(50);
        root.left = new Node(75);
        root.right = new Node(45);
        root.left.left = new Node(40);
        System.out.println(largestBst(root));
    }
}