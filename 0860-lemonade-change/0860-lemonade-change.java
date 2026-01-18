class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0, five = 0, twenty = 0;
        for(int i=0;i<bills.length;i++){
           if(bills[i]==5){
             five += 1;
           }

           else if(bills[i]==10){
            if(five!=0){
                ten+=1;
                five-=1;
            }
            else{
                return false;
            }
           }

           else{
            if(five!=0 && ten!=0){
              ten-= 1;
              five-=1;
            }
            else if(five>=3){
                five-=3;
            }
            else{
                return false;
            }
           }
        }
        return true;
    }
}