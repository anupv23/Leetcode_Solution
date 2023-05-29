class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rs=sb.toString();
        int ans=longestCommonSubsequence(s,rs);
        return ans;
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        // int[][]dp=new int[m+1][m+1];
        int[] prev=new int[m+1];
        int[]curr=new int[m+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                if(i==0 ||j==0) curr[j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            // prev=curr;
            prev=(int[])(curr.clone());
        }
        return prev[m];
    }
}