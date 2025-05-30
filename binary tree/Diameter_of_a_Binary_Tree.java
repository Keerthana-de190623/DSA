class Node {
    int data;
    Node left, right;
    
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Diameter_of_a_Binary_Tree {

    // Helper function to compute height and update diameter
    private int helper(Node root, int[] maxi) {
        if (root == null) return 0;

        int leftHeight = helper(root.left, maxi);
        int rightHeight = helper(root.right, maxi);

        // Update the maximum diameter if current diameter is larger
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameter(Node root) {
        int[] maxi = new int[1]; // maxi[0] holds the max diameter found
        helper(root, maxi);
        return maxi[0];
    }

    // Optional: Test example
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Diameter_of_a_Binary_Tree tree = new Diameter_of_a_Binary_Tree();
        System.out.println("Diameter: " + tree.diameter(root)); // Output should be 3 (4-2-1-3 or 5-2-1-3)
    }
}
