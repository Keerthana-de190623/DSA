// Java code to add two linked list using recursion

class Node {
    int data;
    Node next;

    Node(int val) {
            data = val;
            next = null;
        }
    }

class GfG { 

    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        // Loop to reverse the linked list
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

	// Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
  
    // Recursive function to add two numbers 
  	// represented by linked lists
    static Node addListRec(Node num1, Node num2,
                           					int[] carry) {
      	
        // Base case: If both lists are empty 
      	// and no carry is left
        if (num1 == null && num2 == null && carry[0] == 0) {
            return null;
        }

        int sum = carry[0];

        // Add the value from the first list if it exists
        if (num1 != null) {
            sum += num1.data;
            num1 = num1.next;
        }

        // Add the value from the second list if it exists
        if (num2 != null) {
            sum += num2.data;
            num2 = num2.next;
        }

        carry[0] = sum / 10;
        Node result = new Node(sum % 10);

        // Recursively add remaining digits
        result.next = addListRec(num1, num2, carry);

        return result;
    }

    // Function for adding two linked lists
    static Node addTwoLists(Node num1, Node num2) {
		num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
      
        // Reverse both lists to start addition from 
        // the least significant digit
        num1 = reverse(num1);
        num2 = reverse(num2);

      	// Array used to pass carry by reference
        int[] carry = new int[1];  
        Node result = addListRec(num1, num2, carry);

        // If there's any carry left after the addition, 
		// create a new node for it
        if (carry[0] != 0) {
            Node newNode = new Node(carry[0]);
            newNode.next = result;
            result = newNode;
        }

        // Reverse the list to restore the original order
        return reverse(result);
    }

    // Function to print a linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
      	// Creating first linked list: 
      	// 1 -> 2 -> 3 (represents 123)
        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        // Creating second linked list: 
      	// 9 -> 9 -> 9 (represents 999)
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printList(sum);
    }
}