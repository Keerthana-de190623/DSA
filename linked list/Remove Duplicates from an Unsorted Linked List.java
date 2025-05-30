
class Node {
    int data;
    Node next;
    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

// Function to remove duplicates using nested loops
class GfG {
    static Node removeDuplicates(Node head) {
        Node curr1 = head;

        // Traverse each node in the list
        while (curr1 != null) {
            Node curr2 = curr1;

            // Traverse the remaining nodes to find and 
            // remove duplicates
            while (curr2.next != null) {
                
                // Check if the next node has the same 
                // data as the current node
                if (curr2.next.data == curr1.data) {
                    
                    // Duplicate found, remove it
                    curr2.next = curr2.next.next;
                } else {
                  
                    // If the next node has different data from 
                    // the current node, move to the next node
                    curr2 = curr2.next;
                }
            }
            
            // Move to the next node in the list
            curr1 = curr1.next;
        }
        return head;
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
        
        // Create a singly linked list:
        // 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
        Node head = new Node(12);
        head.next = new Node(11);
        head.next.next = new Node(12);
        head.next.next.next = new Node(21);
        head.next.next.next.next = new Node(41);
        head.next.next.next.next.next = new Node(43);
        head.next.next.next.next.next.next = new Node(21);

        head = removeDuplicates(head);
        printList(head);
    }
}
