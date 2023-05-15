class Solution {
    public int findCircleNum(int[][] isConnected) {
      List<List<Integer>>list=new ArrayList<>();
      int n=isConnected.length;
      int [] vis=new int[n];
      for(int i=0;i<n;i++){
          list.add(new ArrayList<>());
      }
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              if(isConnected[i][j]==1 && i!=j){
                  list.get(i).add(j);
                  list.get(j).add(i);
              }
          }
      }
      int count=0;
      for(int i=0;i<n;i++){
          if(vis[i]==0){
              count++;
              dfs(i,list,vis);
          }
      }
      return count;
    }
    private void dfs(int node,List<List<Integer>>list,int[] vis){
        vis[node]=1;
        for(int it:list.get(node)){
            if(vis[it]==0){
                dfs(it,list,vis);
            }
        }
    }
}