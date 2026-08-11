import java.util.*;
class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        return lengthOfLIS(arr);
    }
    public ArrayList<Integer> lengthOfLIS(int[] nums) {
        // yaha pr do varibles hai
        // index and prev index
        // waise we can take numbers as well but since we need to check strictly incresing
        // agar duplicates number aye to length kam ajeygi as duplicates count nhi honge
        // so it is better to have track of indices than numbers
        int n=nums.length;
        int t[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                t[i][j]=-1;
            }
        }
        int max=func(0,-1,t,nums);
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        int p=-1;
        // abhi we got the maxlen possible for lis
        // abhi kya kr sakte ki curr element ko lekar kya hum
        // ek incresing sequence of length=max bana sakte to if true add it to list and move forward
        while (i<n&&max>0){
            if ((p==-1||nums[i]>nums[p])&&(1+func(i+1,i,t,nums))==max){
                ans.add(nums[i]);
                p=i;
                max--;
            }
            i++;
        }
        return ans;
    }
    public static int func(int i,int p,int t[][],int nums[]){
        if(i==nums.length){
            return 0;
        }
        if(t[i][p+1]!=-1){
            return t[i][p+1];
        }
        int a=0;
        if(p==-1||nums[i]>nums[p]){ // le sakte
            a=1+func(i+1,i,t,nums);
        }
        int b=func(i+1,p,t,nums); // nhi lenge
        // take not take if else me bhi kr sakte but it same so
        // i just keep it simple
        // abhi in do choices me se whatever max is we will take it
        return t[i][p+1]=Math.max(a,b);
    }
}
