import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Bottom_View_of_Binary_Tree {

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        Map<Integer, Integer> mp = new TreeMap<>();    // HD -> Node value
        Map<Integer, Integer> hmp = new HashMap<>();   // HD -> Height

        dfs(root, 0, 0, mp, hmp);

        // Collect result from TreeMap
        return new ArrayList<>(mp.values());
    }

    // Recursive DFS: hd = horizontal distance, ht = height
    private void dfs(Node root, int hd, int ht,
                     Map<Integer, Integer> mp,
                     Map<Integer, Integer> hmp) {

        if (root == null) return;

        // Update if height is greater or equal for the same horizontal distance
        if (!hmp.containsKey(hd) || hmp.get(hd) <= ht) {
            hmp.put(hd, ht);
            mp.put(hd, root.data);
        }

        dfs(root.left, hd - 1, ht + 1, mp, hmp);
        dfs(root.right, hd + 1, ht + 1, mp, hmp);
    }

    // Optional: driver code
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Bottom_View_of_Binary_Tree obj = new Bottom_View_of_Binary_Tree();
        ArrayList<Integer> res = obj.bottomView(root);
        System.out.println("Bottom View: " + res);  // Output: [5, 10, 4, 14, 25]
    }
}
