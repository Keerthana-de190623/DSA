// This Java program finds the number of spanning trees in a
// graph using Matrix Multiplication.

import java.util.*;

public class Main {
    static final int MAX = 100;
    static final int MOD = 1000000007;

    // Matrix Multiplication
    static void multiply(int A[][], int B[][], int C[][])
    {
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                for (int k = 0; k < MAX; k++)
                    C[i][j] = (int)((C[i][j]
                                     + (A[i][k] * B[k][j])
                                           % MOD)
                                    % MOD);
    }

    // Function to find Nth power of A
    static void power(int A[][], int N, int result[][])
    {
        int temp[][] = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                result[i][j] = (i == j) ? 1 : 0;
        while (N > 0) {
            if (N % 2 == 1) {
                multiply(A, result, temp);
                for (int i = 0; i < MAX; i++)
                    for (int j = 0; j < MAX; j++)
                        result[i][j] = temp[i][j];
            }
            N = N / 2;
            multiply(A, A, temp);
            for (int i = 0; i < MAX; i++)
                for (int j = 0; j < MAX; j++)
                    A[i][j] = temp[i][j];
        }
    }

    // Function to find number of Spanning Trees in a Graph
    // using Matrix Multiplication.
    static int numOfSpanningTree(int graph[][], int V)
    {
        int result[][] = new int[MAX][MAX];
        int temp[][] = new int[MAX][MAX];
        // Create a copy of graph as the Adjacency matrix
        // will be changed during the process
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                temp[i][j] = graph[i][j];
        // Find (V-2)th power of Adjacency matrix
        power(temp, V - 2, result);
        int ans = 0;
        // Find sum of all elements in (V-2)th power
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                ans = (int)((ans + result[i][j]) % MOD);
        return ans;
    }

    // Driver program
    public static void main(String[] args)
    {
        // Let us create the following graph
        // 2 <-> 3
        // |   |
        // 0 <-1-> 1
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        int graph[][] = { { 0, 1, 1, 1 },
                          { 1, 0, 1, 1 },
                          { 1, 1, 0, 1 },
                          { 1, 1, 1, 0 } };
        System.out.println(numOfSpanningTree(graph, V));
    }
}