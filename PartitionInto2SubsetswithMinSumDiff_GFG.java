public class PartitionInto2SubsetswithMinSumDiff_GFG {
    public int minDifference(int nums[]) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int t[][]=new int[nums.length+1][total+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=total;j++){
                t[i][j]=-1;

            }
        }
        return func(nums,0,total,nums.length,t);

    }
    public static int func(int arr[],int sum,int total,int n,int t[][]){
        if(n==0){
            return (int)Math.abs(total-2*sum);
        }
        if(t[n][sum]!=-1){
            return t[n][sum];
        }
        int a=func(arr,sum+arr[n-1],total,n-1,t);
        int b=func(arr,sum,total,n-1,t);
        return t[n][sum]=Math.min(a,b);
    }
}
