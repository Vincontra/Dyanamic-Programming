public class PartitionswithGivenDifference {
    public int countPartitions(int[] arr, int diff) {
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        int t[][]=new int[arr.length+1][total+1];
        for (int i=0;i<=arr.length;i++){
            for (int j=0;j<=total;j++){
                t[i][j]=-1;
            }
        }
        return func(total,arr.length,0,t,arr,diff);
    }
    public static int func(int total, int n,int sum,int t[][],int arr[],int diff){
        if (n==0){
            if(total-2*sum==diff){
                return 1;
            }
            return 0;
        }
        if(t[n][sum]!=-1){
            return t[n][sum];
        }
        return t[n][sum]=func(total,n-1,sum+arr[n-1],t,arr,diff)+func(total,n-1,sum,t,arr,diff);
    }
}
