
// Java program to print diagonal view
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Diagonal_Traversal_of_Binary_Tree {

    // Recursive function to print diagonal view
    static void diagonalRecur( Node root, int level,
        		HashMap<Integer, ArrayList<Integer> > levelData) {

        // Base case
        if (root == null)
            return;

        // Append the current node into hash map.
        levelData.computeIfAbsent
          (level, k -> new ArrayList<>()).add(root.data);

        // Recursively traverse the left subtree.
        diagonalRecur(root.left, level + 1, levelData);

        // Recursively traverse the right subtree.
        diagonalRecur(root.right, level, levelData);
    }

    // function to print diagonal view
    static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Create a hash map to store each
        // node at its respective level.
        HashMap<Integer, ArrayList<Integer> > levelData = new HashMap<>();
        diagonalRecur(root, 0, levelData);

        int level = 0;

        // Insert into answer level by level.
        while (levelData.containsKey(level)) {
            ArrayList<Integer> v = levelData.get(level);
            ans.addAll(v);
            level++;
        }

        return ans;
    }

    static void printList(ArrayList<Integer> v) {
        for (int val : v) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard coded tree
        //         8
        //       /   \
        //     3      10
        //    /      /  \
        //   1      6    14
        //         / \   /
        //        4   7 13
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);

        ArrayList<Integer> ans = diagonal(root);
        printList(ans);
    }
}