//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


// class solve {
//     public boolean graphColoring(boolean graph[][], int m, int n) {
//         // Your code here
//     //   int n = G.length;
//         for(int i=0;i<)
//         if (solve(i, graph, color, n, C) == true) return true;
//         return false;
//     }
//     private static boolean isSafe(int node, List < Integer > [] G, int[] color, int n, int col) {
//         for (int it: G[node]) {
//             if (color[it] == col) return false;
//         }
//         return true;
//     }
//     private static boolean solve(int node, List < Integer > [] G, int[] color, int n, int m) {
//         if (node == n) return true;

//         for (int i = 1; i <= m; i++) {
//             if (isSafe(node, G, color, n, i)) {
//                 color[node] = i;
//                 if (solve(node + 1, G, color, n, m) == true) return true;
//                 color[node] = 0;
//             }
//         }
//         return false;
// }
class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors = new int[n];
        return graphColoringUtil(graph, m, colors, 0);
    }

    private boolean graphColoringUtil(boolean[][] graph, int m, int[] colors, int v) {
        if (v == graph.length) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, colors, v, i)) {
                colors[v] = i;
                if (graphColoringUtil(graph, m, colors, v + 1)) {
                    return true;
                }
                colors[v] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(boolean[][] graph, int[] colors, int v, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] && colors[i] == c) {
                return false;
            }
        }
        return true;
    }
}
