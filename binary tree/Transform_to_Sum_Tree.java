
public class Transform_to_Sum_Tree {
    
    public void toSumTree(Node root) {
        convertToSumTree(root);
    }

    private int convertToSumTree(Node node) {
        if (node == null) return 0;

        // Recursively compute left and right subtree sums
        int leftSum = convertToSumTree(node.left);
        int rightSum = convertToSumTree(node.right);

        int oldValue = node.data;

        // Update current node's data
        node.data = leftSum + rightSum;

        // Return the total sum including the original node value
        return node.data + oldValue;
    }
}

