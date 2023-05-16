class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int n=matrix.length;
     int[][]dp=new int[n][n];
     for(int[] row:dp){
     Arrays.fill(row,-1);
    }
    int min=Integer.MAX_VALUE;
    for(int j=0;j<n;j++){
     int m=fun(n-1,j,matrix,dp,n);
     min=Math.min(min,m);
    }
     return min;
    }
    private int fun(int i,int j,int matrix[][],int [][] dp,int n){
        if(j<0||j>=n)return (int)Math.pow(10,9);
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1)return dp[i][j];
        else{
        int straight=matrix[i][j]+fun(i-1,j,matrix,dp,n);
        int left=matrix[i][j]+fun(i-1,j-1,matrix,dp,n);
        int right=matrix[i][j]+fun(i-1,j+1,matrix,dp,n);
        return dp[i][j]=Math.min(straight,Math.min(left,right));}
    }
    
}