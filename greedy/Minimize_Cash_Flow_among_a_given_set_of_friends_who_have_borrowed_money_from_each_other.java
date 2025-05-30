package greedy;
import java.util.*;
public class Minimize_Cash_Flow_among_a_given_set_of_friends_who_have_borrowed_money_from_each_other {
    
// Java program to Minimize Cash Flow among a given set
// of friends who have borrowed money from each other.
    
    // Function to minimize cash flow
    static int[][] minCashFlow(int[][] transaction) {
        int n = transaction.length;
        
        // Priority queues to track people who 
        // need to give money and receive money
        // Array format: {amount, personIndex}
        PriorityQueue<int[]> debtors = 
        new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> creditors = 
        new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // Calculate net amount for each person
        for (int personId = 0; personId < n; personId++) {
            int netAmount = 0;
            
            // Add all incoming money
            for (int fromPerson = 0; fromPerson < n; fromPerson++)
                netAmount += transaction[fromPerson][personId];
            
            // Subtract all outgoing money
            for (int toPerson = 0; toPerson < n; toPerson++)
                netAmount -= transaction[personId][toPerson];
            
            // If net amount is negative, person needs to give money
            if (netAmount < 0)
                debtors.add(new int[]{Math.abs(netAmount), personId});
            
            // If net amount is positive, person needs to receive money
            else if (netAmount > 0)
                creditors.add(new int[]{netAmount, personId});
        }
        
        // Initialize result matrix with zeros
        int[][] result = new int[n][n];
        
        // Process all transactions until no more debtors left
        while (!debtors.isEmpty()) {
            int[] debtor = debtors.poll();
            int[] creditor = creditors.poll();
            int debtAmount = debtor[0];
            int creditAmount = creditor[0];
            int debtorId = debtor[1];
            int creditorId = creditor[1];
            
            // Find minimum of debt and credit amounts
            int transferAmount = Math.min(debtAmount, creditAmount);
            
            // Record the transaction in result matrix
            result[debtorId][creditorId] = transferAmount;
            
            // Update remaining amounts
            debtAmount -= transferAmount;
            creditAmount -= transferAmount;
            
            // If debtor still has debt remaining, put back in queue
            if (debtAmount > 0)
                debtors.add(new int[]{debtAmount, debtorId});
            
            // If creditor still needs to receive more, put back in queue
            else if (creditAmount > 0)
                creditors.add(new int[]{creditAmount, creditorId});
        }
        
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] transaction = {
            {0, 1000, 2000},
            {0, 0, 5000},
            {0, 0, 0}};
        
        int[][] result = minCashFlow(transaction);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}