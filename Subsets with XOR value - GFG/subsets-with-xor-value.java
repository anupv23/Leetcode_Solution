//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        // code here
        return fun(arr,0,K,0);
    }
    static int fun(int[] arr,int idx,int k,int xor){
        if(idx==arr.length){
        return xor==k?1:0;
        }
        int include=fun(arr,idx+1,k,xor^arr[idx]);
        int exclude =fun(arr,idx+1,k,xor);
        return include+exclude;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}
// } Driver Code Ends