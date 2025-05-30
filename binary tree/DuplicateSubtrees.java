import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class DuplicateSubtrees {

    public List<Node> printAllDups(Node root) {
        List<Node> result = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();
        serialize(root, result, subtreeMap);
        return result;
    }

    private String serialize(Node root, List<Node> result, Map<String, Integer> map) {
        if (root == null) return "#";

        String left = serialize(root.left, result, map);
        String right = serialize(root.right, result, map);
        String serialized = left + "," + root.data + "," + right;

        map.put(serialized, map.getOrDefault(serialized, 0) + 1);

        if (map.get(serialized) == 2) {
            result.add(root);
        }

        return serialized;
    }

    // Optional: Test the solution
    public static void main(String[] args) {
        /*
            Tree:
                 1
               /   \
              2     3
             /     / \
            4     2   4
                 /
                4

            Duplicate subtrees:
            - Subtree rooted at 2 (with left child 4)
            - Subtree rooted at 4
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        DuplicateSubtrees ds = new DuplicateSubtrees();
        List<Node> duplicates = ds.printAllDups(root);

        System.out.println("Duplicate Subtree Roots:");
        for (Node node : duplicates) {
            System.out.println("Node: " + node.data);
        }
    }
}
