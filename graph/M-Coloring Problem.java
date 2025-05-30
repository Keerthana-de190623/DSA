class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        int[] nodeColor = new int[v];
        return backtrack(0, v, edges, m, nodeColor);
    }
    boolean backtrack(int node, int v, List<int[]> edges, int m, int[] nodeColor){
        if(node == v) return true;
        
        for(int color = 1; color <= m; color++){
            if(isSafe(node, edges, color, nodeColor)){
                nodeColor[node] = color;
                if(backtrack(node +1, v,edges, m, nodeColor)) return true;
                nodeColor[node] =0;
            }
        }
        return false;
    }
    boolean isSafe(int node, List<int[]> edges,int color, int[] nodeColor){
        
        for(int[] edge : edges){
            if(edge[0] == node && nodeColor[edge[1]] == color) return false;
            if(edge[1] == node && nodeColor[edge[0]] == color) return false;
        }
        return true;
    }
}