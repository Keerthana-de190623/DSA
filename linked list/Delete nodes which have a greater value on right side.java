// Java program to delete nodes 
// which have a greater value on
// right side

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class GfG {
  
    // This function deletes nodes on the 
  	// right side of the linked list
    static Node deleteNodesOnRightSide(Node head) {
      
        // If next is NULL, then there is no node 
      	// with greater value on right side.
        if (head == null || head.next == null) {
            return head;
        }

         // if right node's value is greater than
      	// current node's value, then we can simply 
      	// return the next node
        Node nextNode = 
          deleteNodesOnRightSide(head.next);

         // if current node's value is greater, then
      	// point it to the next node, and return the
      	// the current node.
        if (nextNode.data > head.data) {
            return nextNode;
        }

        // Else point the current node to next node 
      	// and return the head node
        head.next = nextNode;
        return head;
    }

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
      
        // Create linked list
        // 12->15->10->11->5->6->2->3
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        head = deleteNodesOnRightSide(head);

        printList(head);
    }
}