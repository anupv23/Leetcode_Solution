class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     /* meomoization
        int m=text1.length();
        int n=text2.length();
        int[][]dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(m,n,text1,text2,dp);
    }
    private int fun(int i,int j,String s1,String s2,int[][] dp){
        if(i==0||j==0)return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]=1+fun(i-1,j-1,s1,s2,dp);
        }else{
            return dp[i][j]=Math.max(fun(i,j-1,s1,s2,dp),fun(i-1,j,s1,s2,dp));
        }
/*
// ----------------------------------------------------------------------------------        
        /* tabulation*/
        int m=text1.length();
        int n=text2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 ||j==0) dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}