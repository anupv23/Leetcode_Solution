//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
    int[][] dp=new int[n][w+1];
    // for(int [] row:dp){
    //     Arrays.fill(row,-1);
    // }
    //     return fun(N-1,W,val,wt,dp); 
    // }
    // static int fun(int ind,int w,int[] val,int [] wt,int[][]dp){
    //     if(ind==0){
    //         return ((int)w/wt[0]*val[0]);
    //     }
    //     if(dp[ind][w]!=-1) return dp[ind][w];
    //     int notTake=fun(ind-1,w,val,wt,dp);
    //     int take=0;
    //     if(wt[ind]<=w){
    //         take=val[ind]+fun(ind,w-wt[ind],val,wt,dp);
    //     }
    //     return dp[ind][w]=Math.max(take,notTake);
    // }
    for(int i=0;i<=w;i++){
        dp[0][i]=(int)(i/wt[0])*val[0];
    }
    for(int ind=1;ind<n;ind++){
        for(int weight=0;weight<=w;weight++){
            int notTake=dp[ind-1][weight];
            int take=0;
            if(wt[ind]<=weight)
            take=val[ind]+dp[ind][weight-wt[ind]];
            dp[ind][weight]=Math.max(take,notTake);
        }
    }
    return dp[n-1][w];
}
}