class Solution {
    public static boolean BFS(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v){
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[v];
        
        Arrays.fill(parent, -1);
        
        queue.add(start);
        visited[start] = true;
        
        
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int neighbor : adj.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
                
                // current element oda neighbor parent aa ila anaa visited means adhu oru cycle
                else if(neighbor != parent[current]){
                    return true; // cycyle detected if already visited element is not parent
                }
            }
        }
        return false;
    }
    
    
    public boolean isCycle(int v, int[][] edges) {
        // Code here
        
        // Creating the adjacency list given the edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[v];
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(BFS(i, adj, visited, v)){
                    return true;
                }
            }
        }
        return false;
    }
}