// A Java program to replace 
// all 'O's with 'X''s if 
// surrounded by 'X'

class GFG
{
    static int M = 6;
    static int N = 6;
    static void floodFillUtil(char mat[][], int x, 
                              int y, char prevV, 
                              char newV)
    {
        // Base cases
        if (x < 0 || x >= M ||
            y < 0 || y >= N)
            return;
            
        if (mat[x][y] != prevV)
            return;
    
        // Replace the color at (x, y)
        mat[x][y] = newV;
    
        // Recur for north,
        // east, south and west
        floodFillUtil(mat, x + 1, y, 
                      prevV, newV);
        floodFillUtil(mat, x - 1, y, 
                      prevV, newV);
        floodFillUtil(mat, x, y + 1, 
                      prevV, newV);
        floodFillUtil(mat, x, y - 1, 
                      prevV, newV);
    }
    
    // Returns size of maximum 
    // size subsquare matrix
    // surrounded by 'X'
    static void replaceSurrounded(char mat[][])
    {
        
    // Step 1: Replace 
    // all 'O' with '-'
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (mat[i][j] == 'O')
                mat[i][j] = '-';
    
    // Call floodFill for 
    // all '-' lying on edges
    for (int i = 0; i < M; i++) // Left side
        if (mat[i][0] == '-')
            floodFillUtil(mat, i, 0, 
                          '-', 'O');
    for (int i = 0; i < M; i++) // Right side
        if (mat[i][N - 1] == '-')
            floodFillUtil(mat, i, N - 1,
                          '-', 'O');
    for (int i = 0; i < N; i++) // Top side
        if (mat[0][i] == '-')
            floodFillUtil(mat, 0, i,
                          '-', 'O');
    for (int i = 0; i < N; i++) // Bottom side
        if (mat[M - 1][i] == '-')
            floodFillUtil(mat, M - 1, 
                          i, '-', 'O');
    
    // Step 3: Replace 
    // all '-' with 'X'
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (mat[i][j] == '-')
                mat[i][j] = 'X';
    }
    
    // Driver Code
    public static void main (String[] args)
    {
        char[][] mat = {{'X', 'O', 'X', 
                         'O', 'X', 'X'},
                        {'X', 'O', 'X', 
                         'X', 'O', 'X'},
                        {'X', 'X', 'X', 
                         'O', 'X', 'X'},
                        {'O', 'X', 'X',
                         'X', 'X', 'X'},
                        {'X', 'X', 'X',
                         'O', 'X', 'O'},
                        {'O', 'O', 'X',
                         'O', 'O', 'O'}};
                        
        replaceSurrounded(mat);
    
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " "); 
                
            System.out.println("");
        }
    }
}

// This code is contributed 
// by shiv_bhakt