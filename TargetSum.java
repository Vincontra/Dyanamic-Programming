public class TargetSum {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int n=nums.length;
            int tot=0;
            for(int i=0;i<nums.length;i++){
                tot+=nums[i];
            }
            if(target>tot){
                return 0;
            }
            int t[][]=new int[n+1][2*tot+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=2*tot;j++){
                    t[i][j]=-1;
                }
            }
            return func(nums,0,n-1,t,target,tot);

        }
        public static int func(int nums[],int sum,int n,int t[][],int target,int tot){
            if(n==0){
                int cnt=0;
                if(sum+nums[0]==target){
                    cnt++;;
                }
                if(sum-nums[0]==target){
                    cnt++;
                }
                return cnt;
            }
            if(t[n][sum+tot]!=-1){
                return t[n][sum+tot];
            }
            return t[n][sum+tot]=func(nums,sum-nums[n],n-1,t,target,tot)+func(nums,sum+nums[n],n-1,t,target,tot);
        }
    }
}
