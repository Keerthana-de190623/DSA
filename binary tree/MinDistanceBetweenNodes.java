import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class MinDistanceBetweenNodes {

    private HashMap<Node, Node> parent = new HashMap<>();
    private int ans = 0;

    private void mapParent(Node root, Node[] targets, int first, int second) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == first) targets[0] = curr;
            if (curr.data == second) targets[1] = curr;

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    private void solve(Node root, Node tNode, Set<Node> vis, int count) {
        if (root == null || vis.contains(root)) return;

        if (root == tNode) {
            ans = count;
            return;
        }

        vis.add(root);

        solve(root.left, tNode, vis, count + 1);
        solve(root.right, tNode, vis, count + 1);
        if (parent.containsKey(root))
            solve(parent.get(root), tNode, vis, count + 1);
    }

    int findDist(Node root, int a, int b) {
        Node[] targets = new Node[2];
        mapParent(root, targets, a, b);

        Set<Node> vis = new HashSet<>();
        solve(targets[0], targets[1], vis, 0);

        return ans;
    }

    // Optional: Test code
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        MinDistanceBetweenNodes obj = new MinDistanceBetweenNodes();
        int dist = obj.findDist(root, 4, 5);  // Expected: 2
        System.out.println("Distance: " + dist);

        dist = obj.findDist(root, 4, 6);  // Expected: 4
        System.out.println("Distance: " + dist);
    }
}
