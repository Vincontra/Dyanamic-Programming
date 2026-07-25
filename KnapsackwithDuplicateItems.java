public class KnapsackwithDuplicateItems {
    class Solution {
        public int knapSack(int val[], int wt[], int W) {
            int n=wt.length;
            int t[][]=new int[n+1][W+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=W;j++){
                    t[i][j]=-1;
                }
            }
            return func(val,wt,W,n-1,t);
            //unbounded ke andar we do not need to completely empty the sack or completely fill it
            // 0/1 me hota hai wo sab

        }
        public static int func(int val[],int wt[],int W,int n,int t[][]){
            if(n==0){
                if(W-wt[0]>=0){
                    return val[0]*(W/wt[0]);// jitna bhi bharega utna hi theek
                }
                return 0;
            }
            if(W==0){
                return 0;
            }
            if(t[n][W]!=-1){
                return t[n][W];
            }
            if(W-wt[n]>=0){
                return t[n][W]=Math.max(val[n]+func(val,wt,W-wt[n],n,t),func(val,wt,W,n-1,t));
            }
            else{
                return t[n][W]=func(val,wt,W,n-1,t);
            }
        }
    }
}
