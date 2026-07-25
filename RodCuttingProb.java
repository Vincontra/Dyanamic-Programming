public class RodCuttingProb {
    class Solution {
        public int cutRod(int[] price) {
            int n=price.length;
            int t[][]=new int[n+1][n+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    t[i][j]=-1;
                }
            }
            return func(price,n,n-1,t);



        }
        public static int func(int price[],int len,int n,int t[][]){
            if(n==0){
                if(len>=0){
                    return len*price[0];
                }
                return 0;
            }
            if(len==0){
                return 0;
            }
            if(t[n][len]!=-1){
                return t[n][len];
            }
            if(len-(n+1)>=0){
                return t[n][len]=Math.max(price[n]+func(price,len-(n+1),n,t),func(price,len,n-1,t));
            }
            else{
                return t[n][len]=func(price,len,n-1,t);
            }
        }
    }
}
