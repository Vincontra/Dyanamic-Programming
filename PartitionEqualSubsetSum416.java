public class PartitionEqualSubsetSum416 {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        Boolean t[][]=new Boolean[nums.length+1][(sum/2)+1];
        return func(nums,sum/2,t,nums.length);
    }
    public static boolean func(int arr[],int sum,Boolean t[][],int n){
        if (sum==0){
            return true;
        }
        if (n==0){
            return false;
        }
        if (t[n][sum]!=null){
            return t[n][sum];
        }
        if (sum-arr[n-1]>=0){
            return t[n][sum]=func(arr,sum-arr[n-1],t,n-1)||func(arr,sum,t,n-1);
        }else{
            return t[n][sum]=func(arr,sum,t,n-1);
        }
    }
    public static void main(String[] args) {
        int arr[]={2,2,1,1};
        System.out.println(canPartition(arr));

    }
}
