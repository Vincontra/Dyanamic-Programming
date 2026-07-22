public class CoinChange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int n=coins.length;
            int t[][]=new int[n+1][amount+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=amount;j++){
                    t[i][j]=-1;
                }
            }
            return func(amount,coins,t,n-1);
        }
        public static int func(int amount,int arr[],int t[][],int n){
            if(n==0){
                if(amount%arr[0]==0){
                    return 1;
                }
                return 0;
            }
            if(amount==0){
                return 1;
            }
            if(t[n][amount]!=-1){
                return t[n][amount];
            }
            int a=0;
            if(amount-arr[n]>=0){
                a=func(amount-arr[n],arr,t,n);
            }
            int b=func(amount,arr,t,n-1);
            return t[n][amount]=a+b;
        }
    }
}
