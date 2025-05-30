
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class GfG {
    
    // Function to delete a node value when 
    // only a pointer to that node is given
    static void deleteNode(Node delNode) {
        
        // Ensure the node to be deleted is not the last node
        if (delNode == null || delNode.next == null) {
            return;
        }

        // Copy data from the next node into the current node
        Node temp = delNode.next;
        delNode.data = temp.data;

        // Link current node to the node after the next node
        delNode.next = temp.next;

        // Delete the next node (the one whose data was copied)
        temp.next = null;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // Creating a linked list: 4 -> 5 -> 6 -> 7 -> 8
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(8);

        deleteNode(head);

        printList(head);
    }
}

//Time Complexity: O(1)
//Auxiliary Space: O(1)