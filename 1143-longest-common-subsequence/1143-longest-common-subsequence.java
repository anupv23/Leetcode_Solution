class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(m-1,n-1,text1,text2,dp);
    }
    private int fun(int i,int j,String s1,String s2,int[][] dp){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+fun(i-1,j-1,s1,s2,dp);
        }else{
            return dp[i][j]=Math.max(fun(i,j-1,s1,s2,dp),fun(i-1,j,s1,s2,dp));
        }
    }
}