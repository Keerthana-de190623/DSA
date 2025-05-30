class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class GfG {

    // Function to segregate even and odd nodes 
    // and return the head of the new list.
    public static Node segregateEvenOdd(Node head) {

        // Result list to hold even nodes
        Node resStart = null;
        Node resEnd = null;

        // Pointers for the original list
        Node curr = head;
        Node prev = null;

        // Move all even nodes from original to result
        while (curr != null) {

            // If current node is even
            if (curr.data % 2 == 0) {

                // Remove the current even node from the original list
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    // If the even node is at the head
                    head = curr.next;
                }

                // Add the current even node to the result list
                if (resStart == null) {
                    resStart = curr;
                    resEnd = resStart;
                } else {
                    resEnd.next = curr;
                    resEnd = resEnd.next;
                }

                // Move to the next node
                curr = curr.next;
            } else { // If the node is odd, just move to the next
                prev = curr;
                curr = curr.next;
            }
        }

        // If there are no even nodes, return the original list
        if (resStart == null) {
            return head;
        }

        // Append the remaining original list
        // (odd nodes) to the result list
        resEnd.next = head;

        // Return the result list (starting with even nodes)
        return resStart;
    }

    // Function to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Let us create a sample linked list as following
        // 0->1->4->6->9->10->11
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(11);

        System.out.print("Original Linked list: ");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.print("\nModified Linked list: ");
        printList(head);
    }
}