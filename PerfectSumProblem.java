public class PerfectSumProblem {
    class Solution {

        public int perfectSum(int[] nums, int target) {
            int t[][]=new int[nums.length+1][target+1];
            for (int i=0;i<=nums.length;i++){
                for (int j=0;j<=target;j++){
                    t[i][j]=-1;
                }
            }
            return func(nums,target,nums.length,t);
        }
        public static int func(int arr[],int sum,int n,int t[][]){
            if(n==0){
                // this one is diff as there are subsets say empty which also result into count as if tar is 0 empty set is counted
                // so when we encounter the sum==0 return 1 immedialtely wont work here we have to have reach till end
                // that is why i fucked up now i got it after reading the question properly
                if(sum==0){
                    return 1;
                }
                return 0;
            }

            if(t[n][sum]!=-1){
                return t[n][sum];
            }
            int lelo=0;
            if (sum-arr[n-1]>=0){
                lelo=func(arr,sum-arr[n-1],n-1,t);
            }
            int matlo=func(arr,sum,n-1,t);
            return t[n][sum]=lelo+matlo;
        }
    }
}
