public class CoinCahnge {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n=coins.length;
            int t[][]=new int[n][amount+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<=amount;j++){
                    t[i][j]=-1;
                }
            }
            int ans=func(coins,amount,n-1,t);
            if(ans>=Integer.MAX_VALUE){
                return -1;
            }
            return ans;
        }
        public static int func(int arr[],int amount,int n,int t[][]){
            if(n==0){
                if(amount%arr[0]==0){
                    return amount/arr[0];
                }
                return Integer.MAX_VALUE;
            }
            if(t[n][amount]!=-1){
                return t[n][amount];
            }
            int a=Integer.MAX_VALUE;
            if(amount-arr[n]>=0){
                int res=func(arr,amount-arr[n],n,t);
                if(res!=Integer.MAX_VALUE){
                    a=1+res;
                }
            }
            int b=func(arr,amount,n-1,t);
            return t[n][amount]=Math.min(a,b);
        }
    }
}
