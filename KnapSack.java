public class KnapSack {
    class Solution {
        public int knapsack(int W, int val[], int wt[]) {
            int n=wt.length;
            int t[][]=new int[n+1][W+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=W;j++){
                    t[i][j]=-1;
                }
            }
            return func(W,val,wt,t,n-1);


        }
        public static int func(int W,int val[],int wt[],int t[][],int n){
            if(n==0){
                if(W-wt[0]>=0){
                    return val[0];
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
                return t[n][W]=Math.max(val[n]+func(W-wt[n],val,wt,t,n-1),func(W,val,wt,t,n-1));
            }
            else{
                return t[n][W]=func(W,val,wt,t,n-1);
            }

        }
    }

}
