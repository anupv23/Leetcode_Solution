//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
     int[][]dp=new int[n][n];
     for(int j=0;j<n;j++){
        dp[0][j]=matrix[0][j];
     }
     for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
        int straight=straight=matrix[i][j]+dp[i-1][j];
        int left=matrix[i][j];
        if(j>0)left+=dp[i-1][j-1];
        else left+=(int)Math.pow(-10,9);
        int right=matrix[i][j];
        if(j<n-1)right+=dp[i-1][j+1];
        else right+=(int)Math.pow(-10,9);
        dp[i][j]=Math.max(straight,Math.max(left,right));  
         }
        }
        int min=dp[n-1][0];
        for(int j=0;j<n;j++){
            min=Math.max(min,dp[n-1][j]);
        }
        return min;
    }
}