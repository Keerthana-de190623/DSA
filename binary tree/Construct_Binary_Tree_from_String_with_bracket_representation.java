
// Java program to construct a binary 
// tree from the given string

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


public class Construct_Binary_Tree_from_String_with_bracket_representation {
    
    // function to return the index of close parenthesis
    static int findIndex(String str, int i, int j) {
        if (i > j)
            return -1;

        int cnt = 0;

        for (int k = i; k <= j; k++) {
            if (str.charAt(k) == '(') cnt++;
            else if (str.charAt(k) == ')') {
                cnt--;

                if (cnt == 0) return k;
            }
        }

        return -1;
    }

    // function to construct tree from string
    static Node constructTreeRecur(String str, int i, int j) {
        
        // Base case
        if (i > j)
            return null;

        int val = 0;

        // In case the value is having more than 1 digit
        while(i <= j && Character.isDigit(str.charAt(i))) {
            val *= 10;
            val += (str.charAt(i) - '0');
            i++;
        }

        // new root
        Node root = new Node(val);
        int index = -1;

        // if next char is '(' find the index of
        // its complement ')'
        if (i <= j && str.charAt(i) == '(')
            index = findIndex(str, i, j);

        // if index found
        if (index != -1) {

            // call for left subtree
            root.left = constructTreeRecur(str, i + 1, index - 1);

            // call for right subtree
            root.right = constructTreeRecur(str, index + 2, j - 1);
        }

        return root;
    }

    static Node treeFromString(String str) {
        return constructTreeRecur(str, 0, str.length() - 1);
    } 

     static void levelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }


    public static void main(String[] args) {
        String[] str = {"4(2(3)(1))(6(5))"};
        Node root = treeFromString(str[0]);
        levelOrder(root);
    }
}
