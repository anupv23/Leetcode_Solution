class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        int m=s.length();
        int n=t.length();
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
            if(s.charAt(i-1)==t.charAt(j-1)){
            dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }else{
            dp[i][j]=dp[i-1][j];
        }
            }
        }
        return dp[m][n];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     recSol(s.length()-1,t.length()-1,s,t,dp);
    //     return dp[s.length()-1][t.length()-1];
    // }
    // public int recSol(int i,int j,String s,String t,int[][] dp){
    //     if(j<0){
    //         return 1;
    //     }
    //     if(i<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int x=0,y=0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         x=recSol(i-1,j,s,t,dp)+recSol(i-1,j-1,s,t,dp);
    //     }else{
    //         y=recSol(i-1,j,s,t,dp);
    //     }
    //     return dp[i][j]= x+y;

    }
}