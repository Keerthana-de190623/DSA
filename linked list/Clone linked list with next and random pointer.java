

import java.util.HashMap;
import java.util.Map;

// Define the Node class
class Node {
    int data;
    Node next;
    Node random;
  
    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class GfG {

    // Function to clone the linked list
    static Node cloneLinkedList(Node head) {
  
        // Hash Map to store new nodes corresponding  
      	// to their original nodes
        Map<Node, Node> mp = new HashMap<>();
        Node curr = head;
  
        // Traverse original linked list to store new nodes 
      	// corresponding to original linked list
        while (curr != null) {
            mp.put(curr, new Node(curr.data));
            curr = curr.next;
        }
    
        curr = head;
    
        // Loop to update the next and random pointers
      	// of new nodes 
        while (curr != null) {
        
            // Update the next pointer of new node
            Node newNode = mp.get(curr);
            newNode.next = mp.get(curr.next);
      
            // Update the random pointer of new node
            newNode.random = mp.get(curr.random);
      
            curr = curr.next;
        }
  
        // Return the head of the clone
        return mp.get(head);
    }

    // Function to print the linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null)
                System.out.print(head.random.data + ")");
            else 
                System.out.print("null" + ")");
        
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
  
        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;
  
        // Print the original list
        System.out.println("Original linked list:");
        printList(head);
  
        // Function call
        Node clonedList = cloneLinkedList(head);
  
        System.out.println("Cloned linked list:");
        printList(clonedList);
    }
}