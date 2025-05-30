// Java code to detect and remove loop in linked
// list using hashing

import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to detect and remove loop in a linked list
    static void removeLoop(Node head) {

        // hash set to hash addresses of
        // the linked list nodes
        HashSet<Node> st = new HashSet<>();

        // pointer to prev node
        Node prev = null;
        while (head != null) {

            // if node not present in the map,
            // insert it in the map
            if (!st.contains(head)) {
                st.add(head);
                prev = head;
                head = head.next;
            }

            // if present, it is a cycle, make
            // last node's next pointer NULL
            else {
                prev.next = null;
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        // Create a loop
        head.next.next.next = head.next;

        removeLoop(head);
        printList(head);
    }
}