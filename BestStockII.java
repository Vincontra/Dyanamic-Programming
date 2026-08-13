public class BestStockII {
   // Best Time to Buy and Sell Stock II
   class Solution1 {
       public int maxProfit(int[]arr) {
           // har inde pr do choices
           // agar kharida hai to bech sakte or skip
           // agar nhi to kharid sakte or skip
           int n=arr.length;
           int t[][]=new int[n+1][3]; // states hone chhaiye index and kharid ki nhi
           for (int i=0;i<=n;i++) {
               for (int j=0;j<=2;j++) {
                   t[i][j]=-1;
               }
           }
           return func(arr,t,0,1);
       }
       public static int func(int arr[], int t[][], int i, int j) {
           if(i==arr.length){
               return 0;
           }
           if (t[i][j]!=-1) {
               return t[i][j];
           }
           if (j==1){// kaharid sakte or skip
               return t[i][j]=Math.max(func(arr,t,i+1,0)-arr[i],func(arr,t,i+1,1));
           }
           else {/// bech sakte or skip
               return t[i][j]=Math.max(func(arr,t,i+1,1)+arr[i],func(arr,t,i+1,0));
           }

       }

   }
}
