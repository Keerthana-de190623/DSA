

import java.util.ArrayList;


public class Left_View_of_Binary_Tree {
    
   public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list, 0);
        return list;
    }
    private void solve(Node root, ArrayList<Integer> list, int level) {
        if (root == null) return;

        if (list.size() == level) {
            list.add(root.data);
        }

        solve(root.left, list, level + 1);
        solve(root.right, list, level + 1);
    }
}
