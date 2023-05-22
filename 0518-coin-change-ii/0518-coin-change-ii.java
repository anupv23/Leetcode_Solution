class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //    int x=fun(coins.length-1,amount,coins,dp);
    //    return x; 
    // }
    // private int fun(int ind,int t,int[] arr,int[][] dp){
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)dp[0][i]=1;
            else
            dp[0][i]=0; 
        }
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=amount;tar++){
                int notTake=dp[ind-1][tar];
                int take=0;
                if(coins[ind]<=tar) take=dp[ind][tar-coins[ind]];
                 dp[ind][tar]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}