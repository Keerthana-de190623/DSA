import java.util.*;

// Node of the binary tree
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {
    // Function to print flattened binary tree
    static void print(Node parent)
    {
        Node curr = parent;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Function to perform in-order traversal recursively
    static void inorder(List<Integer> traversal,
                        Node parent)
    {
        // Base Case
        if (parent == null)
            return;

        inorder(traversal, parent.left);
        // Storing the values in the list
        traversal.add(parent.data);

        inorder(traversal, parent.right);
    }

    static void form(int pos, List<Integer> traversal,
                     Node[] prev)
    {
        // Base Case
        if (pos == traversal.size())
            return;

        prev[0].right = new Node(traversal.get(pos));
        prev[0].left = null;

        prev[0] = prev[0].right;

        // Calling for the next element of the list
        form(pos + 1, traversal, prev);
    }

    // Function to flatten binary tree using level order
    // traversal
    static Node flatten(Node parent)
    {
        // Dummy node
        Node dummy = new Node(-1);

        // Pointer to previous element
        Node[] prev = { dummy };

        // List to store the inorder traversal of the binary
        // tree
        List<Integer> traversal = new ArrayList<>();
        inorder(traversal, parent);

        // forming the sorted list from the list obtained
        form(0, traversal, prev);

        prev[0].left = null;
        prev[0].right = null;
        Node ret = dummy.right;

        // Delete dummy node
        dummy = null;
        return ret;
    }

    public static void main(String[] args)
    {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        // Calling required function
        print(flatten(root));
    }
}