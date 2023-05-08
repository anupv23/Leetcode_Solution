class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sfive=0;
        int sten=0;
        for(int i:bills){
            if(i==5){
                sfive++;
            }else if(i==10){
                    sfive--;
                    sten++;
            }else if(sten>0){
                sten--;
                sfive--;
            }else{
                sfive-=3;
            }
          if(sfive<0) return false;   
        }
        return true;
    }
}