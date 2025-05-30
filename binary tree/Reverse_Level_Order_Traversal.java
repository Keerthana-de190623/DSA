import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Reverse_Level_Order_Traversal {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            stack.push(curr.data);  // Push current node's data
            
            // Enqueue right child first, then left child
            if (curr.right != null) q.offer(curr.right);
            if (curr.left != null) q.offer(curr.left);
        }

        // Pop all items from stack to get reverse level order
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        /*
            Example Tree:
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7

            Reverse Level Order: 4 5 6 7 2 3 1
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Reverse_Level_Order_Traversal sol = new Reverse_Level_Order_Traversal();
        System.out.println(sol.reverseLevelOrder(root));  // Output: [4, 5, 6, 7, 2, 3, 1]
    }
}
