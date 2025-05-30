class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges){
        int matrix[][] = build(edges,n);
        shortestDistance(matrix,false);
        return shortestDistance(matrix,true);
    }
    int[][] build(int[][] edges,int n){
        int a[][] = new int[n][n];
        for(int i[]:a)  Arrays.fill(i,(int)1e9);
        for(int i=0;i<n;i++)    a[i][i]=0;
        for(int e[]:edges){
            int u = e[0], v = e[1], w = e[2];
            a[u][v] = w;
        }
        return a;
    }
    public int shortestDistance(int[][] matrix,boolean checking) {
        int n=matrix.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==k || j==k || matrix[i][k]==(int)1e9 || matrix[k][j]==(int)1e9)    continue;
                    if(checking && matrix[i][k] + matrix[k][j]<matrix[i][j])    return 1;
	                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return 0;
    }
}