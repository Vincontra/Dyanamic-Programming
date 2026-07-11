public class SubsetSumEqualsK
{
    static Boolean isSubsetSum(int arr[], int sum) {
        boolean t[][]=new boolean[arr.length+1][sum+1];
        return func(arr,sum,arr.length,t);
    }
    public static boolean func(int arr[],int sum,int n,boolean t[][]){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if (t[n][sum]){
            return true;
        }
        if(sum-arr[n-1]>=0){
            return t[n][sum]=func(arr,sum-arr[n-1],n-1,t)||func(arr,sum,n-1,t);
        }else{
            return t[n][sum]=func(arr,sum,n-1,t);
        }
    }
}
