class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
      Arrays.sort(nums,(arr1,arr2)->arr1[1]-arr2[1]);
       int c=1,d=nums[0][1];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i][0]>=d)
            {
                c+=1;
                d=nums[i][1];
            }
        }
        return nums.length-c;
    }
}