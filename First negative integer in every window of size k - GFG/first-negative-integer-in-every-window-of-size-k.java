//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        List<Long>list=new ArrayList<>();
        long[] ans=new long[N-k+1];
        int i=0,j=0;
        while(j<N){
            if(j-i+1<k){
                if(A[j]<0)list.add(A[j]);
                j++;
            }
            else if(j-i+1==k){
                if(A[j]<0)list.add(A[j]);
               if(list.size()==0){
                   ans[i]=0;
               }else{
                   ans[i]=list.get(0);
               }
               if(A[i]<0)list.remove(A[i]);
               i++;
               j++;
            }
        }
        return ans;
    }
}