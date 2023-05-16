class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int n=matrix.length;
     int[][]dp=new int[n][n];
     for(int j=0;j<n;j++){
        dp[0][j]=matrix[0][j];
     }
     for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
        int straight=straight=matrix[i][j]+dp[i-1][j];
        int left=matrix[i][j];
        if(j>0)left+=dp[i-1][j-1];
        else left+=(int)Math.pow(10,9);
        int right=matrix[i][j];
        if(j<n-1)right+=dp[i-1][j+1];
        else right+=(int)Math.pow(10,9);
        dp[i][j]=Math.min(straight,Math.min(left,right));  
         }
        }
        int min=dp[n-1][0];
        for(int j=0;j<n;j++){
            min=Math.min(min,dp[n-1][j]);
        }
        return min;
    }
    
}