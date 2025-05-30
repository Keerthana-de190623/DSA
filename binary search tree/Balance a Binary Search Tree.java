// Java program to convert a left unbalanced BST to
// a balanced BST

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class GFG {

    // Inorder traversal to store elements of the
    // tree in sorted order
    static void storeInorder(Node root, ArrayList<Integer> nodes) {
        if (root == null)
            return;

        // Traverse the left subtree
        storeInorder(root.left, nodes);

        // Store the node data
        nodes.add(root.data);

        // Traverse the right subtree
        storeInorder(root.right, nodes);
    }

    // Function to build a balanced BST from a sorted array
    static Node buildBalancedTree(ArrayList<Integer> nodes, int start, int end) {

        // Base case
        if (start > end)
            return null;

        // Get the middle element and make it the root
        int mid = (start + end) / 2;
        Node root = new Node(nodes.get(mid));

        // Recursively build the left and right subtrees
        root.left = buildBalancedTree(nodes, start, mid - 1);
        root.right = buildBalancedTree(nodes, mid + 1, end);

        return root;
    }

    // Function to balance a BST
    static Node balanceBST(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();

        // Store the nodes in sorted order
        storeInorder(root, nodes);

        // Build the balanced tree from the sorted nodes
        return buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    // Print tree as level order
    static void printLevelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        int nonNull = 1;

        while (!qq.isEmpty() && nonNull > 0) {
            Node curr = qq.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(curr.data + " ");
            qq.add(curr.left);
            qq.add(curr.right);
            if (curr.left != null)
                nonNull++;
            if (curr.right != null)
                nonNull++;
        }
    }

    public static void main(String[] args) {

        // Constructing an unbalanced BST
        //        4
        //       / \
        //      3   5
        //     /     \
        //    2       6
        //   /		   \
        //  1		    7

        Node root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        Node balancedRoot = balanceBST(root);
        printLevelOrder(balancedRoot);
    }
}
