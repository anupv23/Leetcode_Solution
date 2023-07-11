//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
class Pair{
    int start;
    int end;
    Pair(int start,int end){
        this.start=start;
        this.end= end;
    }
}
class MeetingComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair o1,Pair o2){
        if(o1.end <= o2.end){
            return -1;
        }
        else{
            return 1;
        }
        
    }
}

class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        if(n==0)return 0;
        ArrayList<Pair> p = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            p.add(new Pair(start[i],end[i]));
        }
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(p,mc);
        int endTime = p.get(0).end;
        int count=1;
        for(int i =1;i<n;i++){
            if(p.get(i).start> endTime){
                count++;
                endTime = p.get(i).end;
            }
        }
        
        return count;
        
        
    }
}